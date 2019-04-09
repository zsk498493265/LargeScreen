package com.organOld.outService.service;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.KeyRulelModel;
import com.organOld.outService.contract.Result;

public interface OldmanKeyService {
    String getByPage(BTableRequest bTableRequest, OldmanKeyRequest oldmanKeyRequest);

    Result updateMan(String futureTime);
//    void updateKey(List<OldmanKey> oldmanKeys);

    int calculateKeyGoal(OldmanKey oldmanKey);

    void checkKeyStatus(Oldman oldman);

    Result autoUpdateMan(Boolean open);

    KeyRulelModel getRule();

    void updateRule(KeyRuleRequest keyRuleRequest);

    Result handle(OldmanhKeyHandleRequest oldmanhKeyHandleRequest);

    Result getHandleByOldmanId(int oldmanId);

    Result handleDel(String[] oldmanIds);

    void calculateChxHealthGoal();
}
