package com.example.accounts;

import com.example.accounts.bean.UserBean;
import com.example.accounts.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//使Service可以注入
@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountsApplicationTests {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.register("test","test");
        // System.out.println("该用户ID为：");
    }
}
