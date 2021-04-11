package com.example.accounts.controller;

import com.example.accounts.bean.UserBean;
import com.example.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String show(){
        return "index";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    // public String login(String username, String password) {
    public Object login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
        String statusCode = userService.login(username, password);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>(statusCode, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    // public String register(String username, String password) {
    public Object register(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
        String statusCode = userService.register(username, password);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>(statusCode, responseHeaders, HttpStatus.OK);
    }
}
