package com.organOld.outService.thread;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.outService.dwr.DwrData;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.service.HomeService;
import com.organOld.outService.service.OldmanService;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.tool.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 每个线程获取一定数量（ROUND）的实体 进行更新
 * max 是总数量
 */
@Service
public class OldStatusOrganUpdate {

    @Autowired
    OrganService organService;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    OldStatusHomeUpdate oldStatusUpdate;


    public static Lock lock = new ReentrantLock();

    public static final Logger log = LoggerFactory.getLogger(OldStatusOrganUpdate.class);

    private static final long LONG_POLLING_EXECUTOR_DELAY = 1000;


    /**
     * The timeout for loading data once.
     */
    private static final long ROUND = 2000L;

    /**
     * The timeout for loading data once.
     */
    private static final long LOADER_TIMEOUT = 10 * 1000;

    /**
     * The null value of {@link Long} type in the redis.
     */
    public static final long REDIS_NULL_VALUE = Long.MIN_VALUE;

    /**
     * The timeout for getting the distributed lock.
     */
    public static final long LOCK_TIMEOUT = 2 * 1000;


    /**
     * The timeout for updating data once.
     */
    private static final long UPDATE_TIMEOUT = 20 * 1000;
    /**
     * 开关
     */
    public static volatile Boolean DOING= true;


    public static volatile Boolean finish=false;//更新是否完成

    /**
     * The sequence number for creating working thread.
     */
    private final AtomicInteger workerSequenceNumber = new AtomicInteger();
    /**
     * The count of the working threads.
     */
    private static final int WORKER_COUNT = 4;
    /**
     * the worker executor to handle the data.
     */
    private final ExecutorService workerExecutor = Executors.newFixedThreadPool(WORKER_COUNT, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("worker-updater-"+workerSequenceNumber.incrementAndGet());
        return thread;
    });

    private volatile List<Organ> organTypeMap=new ArrayList<>();

    /**
     * The long-polling executor will be scheduled with the given interval.
     */
    public ScheduledExecutorService longPollingExecutor = Executors.newScheduledThreadPool(1, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("update");
        return thread;
    });

    /**
     * The loader executor to load the data to update with asynchronous strategy.
     */
    private final ScheduledExecutorService loaderExecutor = Executors.newScheduledThreadPool(1, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setName("loader-updater-" );
        return thread;
    });



    public Runnable updateRunner = new Runnable() {
        @Override
        public void run() {
            try {
                if(getValue("oldstatus_home_init")==REDIS_NULL_VALUE){
                    //初始化
                    init();
                }
                if (needToUpdate()) {
                    log.info("update!!!");
                    update();
                }
            } catch (Exception ex) {
                Remote.noticeByfunction("finishOldStatus",9999);
                log.error("An exception occurred when long-polling-updater-{} was working", ex);
            }finally {
                if(DOING){
                    longPollingExecutor.schedule(updateRunner, LONG_POLLING_EXECUTOR_DELAY, TimeUnit.MILLISECONDS);
                }
            }
        }
    };

    public void init(){
        if(organTypeMap.size()==0)
            organTypeMap=organService.getOrganTypeMap();
        this.setMax(this.max());
        this.setCurrent(0L);
        this.setValue("oldstatus_home_init","1",0L);
    }

    public boolean needToUpdate() {
            long max = this.getMax(), current=this.getCurrent();
            if (current >= max) {
                DOING=false;
                finish=true;
                this.setValue("oldstatus_home_init",String.valueOf(REDIS_NULL_VALUE),0L);
                OldStatusHomeUpdate.DOING=true;
                OldStatusHomeUpdate.finish=false;
                oldStatusUpdate.longPollingExecutor.execute(oldStatusUpdate.updateRunner);
                return false;
            }
            return true;
    }

    public void update() {
        try {
            Future<List<OrganOldman>> future = this.loaderExecutor.submit(() -> load());
            List<OrganOldman> loadedData = future.get(LOADER_TIMEOUT, TimeUnit.MILLISECONDS);
            if (loadedData != null && loadedData.size() > 0) {
                log.info(loadedData.size()+"");
                CountDownLatch countDownLatch = new CountDownLatch(loadedData.size());
                List<Oldman> oldmanList=new CopyOnWriteArrayList();;
                for (OrganOldman organOldman : loadedData) {
                    this.workerExecutor.execute(() -> {
                        try {
                            Oldman oldman=new Oldman();
                            oldman.setId(organOldman.getOldmanId());
                            log.info(oldman.toString());
                            if(organTypeMap.get(organTypeMap.indexOf(new Organ(organOldman.getOrganId()))).getOrganFirTypeId()==21){
                                //机构养老
                                oldman.setOldStatus(1);
                            }else{
                                oldman.setOldStatus(2);
                            }
                            log.info(oldman.toString());
                            oldmanList.add(oldman);
                        } catch (Exception ex) {
                            log.error("Failed to convert the data [{}] to the target type", organOldman, ex);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                if (countDownLatch.await(UPDATE_TIMEOUT, TimeUnit.MILLISECONDS)) {
                    this.triggerAfterUpdateEvents(oldmanList);
                }
            }
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            log.error("Failed to update the data in the .");
        }
    }

    protected List<OrganOldman> load() {
        List<OrganOldman> data = new ArrayList<>();
        boolean locked = false;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                long current = this.getCurrent();
                if (current < this.getMax()) {
                    data = this.load(current);
                    this.setCurrent(this.current(data));
                }
            }

        }catch (Exception ex) {
            log.warn("Failed to load the data.", ex);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return data;
    }

    protected List<OrganOldman> load(long current) {
        return organService.getOrganOldmanOidByRound(ROUND,current);

    }


    /**
     * Execute all registered
     * The method will block the current thread.
     *
     * @param updatedData the updated data.
     */
    private void triggerAfterUpdateEvents(List<Oldman> updatedData) {
        oldmanService.updateOrganOldStatusByOldmanIds(updatedData);
    }


    /**
     * Gets the value with the given key in the redis with synchronous strategy.
     *
     * @param key the key to get in the redis.
     * @return the value corresponding with the given key. If any exception occur or empty value, zero will be returned.
     */
    private long getValue(final String key) {
        boolean locked = false;
        long result = REDIS_NULL_VALUE;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                String value = (String) Cache.get(key);
                if (value != null && !value.equals(result+"")) {
                    result = Long.valueOf(value);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to obtain lock when get key [{}] in the redis [{}].", key, e);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return result;
    }

    public void setValue(final String key, final String value,Long time) {
        boolean locked = false;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                boolean isSuccess;
                if (time!=0L){
                    isSuccess= Cache.put(key, value,time);
                }else{
                    isSuccess= Cache.put(key, value);
                }

                if (!isSuccess) {
                    log.error("Failed to set key [{}] and value [{}] into the redis.", key, value);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to obtain lock when set key [{}] and value [{}] into the redis .", key, value);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }



    public long getMax() {
        return this.getValue("oldstatus_home_max");
    }

    public void setMax(long max) {
        this.setValue("oldstatus_home_max", String.valueOf(max),0L);
    }

    public long getCurrent() {
        return this.getValue("oldstatus_home_current");
    }

    public void setCurrent(long current) {
        this.setValue("oldstatus_home_current", String.valueOf(current),0L);
    }


    protected long max() {
        return organService.getOrganOldmanOidSize();
    }



    protected long current(List<OrganOldman> data) {
        Long count = getCurrent();
        if (!CollectionUtils.isEmpty(data)) {
            count+=data.size();
        }
        return count;
    }
}
