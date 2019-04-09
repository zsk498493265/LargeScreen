package com.organOld.outService.wrapper;

import com.organOld.dao.entity.Message;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.MessageRequest;
import com.organOld.outService.enumModel.MessageTypeEnum;
import com.organOld.outService.model.MessageModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageWrapper implements Wrapper<Message,MessageModel,MessageRequest> {


    @Override
    public MessageModel wrap(Message message) {
        MessageModel messageModel=new MessageModel();
        messageModel.setContent(message.getContent());
        messageModel.setTypeName(MessageTypeEnum.getValue(message.getType()));
        messageModel.setOrgan(message.getOrgan());
        messageModel.setTime(Tool.dateToString(message.getTime(), TimeConstant.DATA_FORMAT_YMD));
        messageModel.setIdAndIsRead(message.getId()+"#"+message.getIsRead());
        return messageModel;
    }

    @Override
    public Message unwrap(MessageRequest messageRequest) {
        Message message=new Message();
        BeanUtils.copyProperties(messageRequest,message);
        return message;
    }
}
