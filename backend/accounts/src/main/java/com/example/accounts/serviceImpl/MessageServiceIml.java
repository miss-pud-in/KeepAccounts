package com.example.accounts.serviceImpl;

import com.example.accounts.bean.MessageBean;
import com.example.accounts.mapper.MessageMapper;
import com.example.accounts.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceIml implements MessageService {

    //将DAO注入Service层
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public MessageBean addNewMessage(int formId, int toId, int type) {
        MessageBean messageBean = new MessageBean(formId, toId, type);
        messageMapper.insert(messageBean);
        return messageBean;
    }
}
