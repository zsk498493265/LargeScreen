package com.organOld.outService.wrapper;

import com.organOld.dao.entity.record.Record;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.CardRecordRequest;
import com.organOld.outService.contract.RecordRequest;
import com.organOld.outService.enumModel.LabelTypeEnum;
import com.organOld.outService.enumModel.RecordTypeEnum;
import com.organOld.outService.enumModel.SignPeopleTypeEnum;
import com.organOld.outService.model.RecordModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RecordWrapper implements Wrapper<Record,RecordModel,RecordRequest> {


    @Override
    public RecordModel wrap(Record record) {
        RecordModel recordModel=new RecordModel();
        recordModel.setId(record.getId());
        recordModel.setData(record.getData());
        recordModel.setOldman(record.getOldman());
        recordModel.setTime(Tool.dateToString(record.getTime(), TimeConstant.DATA_FORMAT_YMDHMS));
        recordModel.setOrgan(record.getOrgan());
        recordModel.setType(RecordTypeEnum.getValue(record.getType()));
        recordModel.setOrder(record.getOrder());
        recordModel.setHdTime(record.getHdTime());
        if(record.getType()==2){
            recordModel.setHdName(record.getName());
            if(record.getHdType()!=0)
                recordModel.setHdType(LabelTypeEnum.getValue(record.getHdType()));
            if(record.getPeopleType()!=0)
                recordModel.setPeopleType(SignPeopleTypeEnum.getValue(record.getPeopleType()));
            if(record.getOrder()!=null) {
                switch (record.getOrder()) {
                    case "1":
                        recordModel.setSecType("日常签到");
                        break;
                    case "2":
                        recordModel.setSecType("活动签到");
                        break;
                }
            }
        }
        if(record.getType()==4){
            if(record.getOrder()!=null) {
                switch (record.getOrder()) {
                    case "1":
                        recordModel.setSecType("积分查询");
                        break;
                    case "2":
                        recordModel.setSecType("积分兑换");
                        recordModel.setIntegral(record.getData());
                        break;
                }
            }
        }
        if(record.getPrevMoney()!=null){
            if(record.getType()==9){
                recordModel.setMoneyChange(record.getPrevMoney().intValue()+"--->"+record.getNowMoney().intValue());
            }else{
                recordModel.setMoneyChange(record.getPrevMoney()+"--->"+record.getNowMoney());
            }
        }

        if(record.getType()==9){
            //积分记录
            if(record.getOrder()!=null) {
                String value="";
                switch (record.getOrder()) {
                    case "1":
                        value="消费";
                        break;
                    case "2":
                        value="日常签到增加";
                        break;
                    case "3":
                        value="活动签到增加";
                        break;
                    case "4":
                        value="积分兑换";
                        break;
                    case "5":
                        value="积分清零";
                        break;
                    case "6":
                        value="积分添加";
                        break;
                    case "7":
                        value="积分扣除";
                        break;

                }
                recordModel.setOrder(value);
            }

        }
        return recordModel;
    }

    @Override
    public Record unwrap(RecordRequest recordRequest) {
        Record record=new Record();
        if(recordRequest.getOrder()!=null)
        record.setOrder(recordRequest.getOrder()+"");
        BeanUtils.copyProperties(recordRequest,record);
        record.setStart(Tool.stringToDate(recordRequest.getStart()));
        record.setEnd(Tool.stringToDate(recordRequest.getEnd()));
        return record;
    }

    public Record unwrapCard(CardRecordRequest cardRecordRequest) {
        Record record=new Record();
        record.setCardId(cardRecordRequest.getId());
        record.setStart(Tool.stringToDate(cardRecordRequest.getStart()));
        record.setEnd(Tool.stringToDate(cardRecordRequest.getEnd()));
        record.setType(cardRecordRequest.getType());
        return record;
    }


}
