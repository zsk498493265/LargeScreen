package com.organOld.outService.service.impl;

import com.organOld.dao.entity.Message;
import com.organOld.dao.repository.MessageDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.MessageRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.model.MessageModel;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.MessageService;
import com.organOld.outService.wrapper.MessageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;
    @Autowired
    CommonService commonService;
    @Autowired
    MessageWrapper messageWrapper;

    @Override
    public String getByPage(MessageRequest messageRequest, BTableRequest bTableRequest) {
        Page<Message> page=commonService.getPage(bTableRequest,"message");
        Message message= messageWrapper.unwrap(messageRequest);
        String username=commonService.getUserNameBySession();
        message.setUsername(username);
        page.setEntity(message);
        List<MessageModel> messageModelList=messageDao.getByPage(page).stream().map(messageWrapper::wrap).collect(Collectors.toList());
        Long size=messageDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,messageModelList);
    }

    @Override
    public Result read(String[] ids) {
        String username=commonService.getUserNameBySession();
        messageDao.readByUsername(username,ids);
        return new Result(true);
    }

    @Override
    public int getNoReadNum() {
        String username=commonService.getUserNameBySession();
        return messageDao.getNoReadNumByUsername(username);
    }

    @Override
    public void delByIds(String[] ids) {
            Integer[] id=new Integer[ids.length];
            for(int i=0;i<ids.length;i++){
                id[i]=Integer.parseInt(ids[i]);
            }
            messageDao.delByIds(id);
    }
}
