package com.example.accounts.service;

import com.example.accounts.bean.MessageBean;

public interface MessageService {

    MessageBean addNewMessage(int formId, int toId, int type);

}
