package com.example.accounts.controller;

import com.example.accounts.bean.LabelBean;
import com.example.accounts.bean.UserBean;
import com.example.accounts.bean.BookBean;
import com.example.accounts.service.LabelService;
import com.example.accounts.service.UserService;
import com.example.accounts.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    LabelService labelService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/getAllBooks",method = RequestMethod.POST)
    public Object getAllBooks(@RequestParam(value = "username") String username) {
        UserBean userBean = userService.getInfo(username);
        List<BookBean> bookBeanList = bookService.getByOwnerId(userBean.getId());
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List>(bookBeanList, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/getBooksWithNoMonthly",method = RequestMethod.POST)
    public Object getBooksWithNoMonthly(@RequestParam(value = "username") String username) {
        UserBean userBean = userService.getInfo(username);
        List<BookBean> bookBeanList = bookService.getByOwnerIdWithoutMonthlyBook(userBean.getId());
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List>(bookBeanList, responseHeaders, HttpStatus.OK);
    }

}