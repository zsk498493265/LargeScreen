package com.organOld.outService.service;

import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.MessageRequest;
import com.organOld.outService.contract.Result;

public interface MessageService {
    String getByPage(MessageRequest messageRequest, BTableRequest bTableRequest);

    Result read(String[] ids);

    int getNoReadNum();

    void delByIds(String[] ids);
}
