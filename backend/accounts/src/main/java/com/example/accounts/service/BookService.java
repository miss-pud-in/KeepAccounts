package com.example.accounts.service;

import com.example.accounts.bean.BookBean;

import java.util.List;

public interface BookService {

    BookBean getBookById(int id);
    /* 获取一个用户的全部账本 */
    List<BookBean> getByUserId(int userId);
    BookBean addNewBook(int userId, BookBean bookBean);
    BookBean ifBookExists(int userId, String name);

}
