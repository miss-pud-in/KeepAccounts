package com.example.accounts.mapper;

import com.example.accounts.bean.UserBean;

public interface UserMapper {

    UserBean getByName(String name);
    void insert(UserBean userBean);
    void update(UserBean userBean);

}
