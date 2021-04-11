package com.example.accounts.mapper;

import com.example.accounts.bean.MessageBean;

public interface MessageMapper {

    MessageBean getById(int id);
    void insert(MessageBean messageBean);
    void update(MessageBean messageBean);
    void delete(int id);

}
