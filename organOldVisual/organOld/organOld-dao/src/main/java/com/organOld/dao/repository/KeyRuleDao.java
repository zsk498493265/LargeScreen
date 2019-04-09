package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.KeyRule;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface KeyRuleDao {
    CopyOnWriteArrayList<KeyRule> getAll();

    List<KeyRule> getAllRule();

    void updateByIds(List<KeyRule> keyRuleList);
}
