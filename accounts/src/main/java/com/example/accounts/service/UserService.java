package com.example.accounts.service;

import com.example.accounts.bean.UserBean;

public interface UserService {

    String login(String name, String password);
    String register(String name, String password);
    UserBean getInfo(String name);

}
