package com.example.accounts.service;

import com.example.accounts.bean.BookBean;

import java.util.List;

public interface BookService {

    BookBean getBookById(int id);
    /* 获取一个用户的全部账本 */
    List<BookBean> getByOwnerId(int userId);
    /* 获取一个用户除了月账本之外的全部账本 */
    List<BookBean> getByOwnerIdWithoutMonthlyBook(int userId);
    BookBean addNewBook(int userId, BookBean bookBean);
    BookBean ifBookExists(int userId, String name);

}
