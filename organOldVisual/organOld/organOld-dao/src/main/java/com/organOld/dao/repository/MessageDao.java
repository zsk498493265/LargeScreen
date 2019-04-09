package com.organOld.dao.repository;

import com.organOld.dao.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao extends BaseDao<Message,Number> {
    void saveAllMessage(@Param("userIds") List<Integer> userIds,@Param("message") Message message);

    void readByUsername(@Param("username") String username,@Param("ids") String[] ids);

    int getNoReadNumByUsername(String username);

    void saveAllMessages(List<Message> messageList);

    void saveAllBySame(Message message);
}
