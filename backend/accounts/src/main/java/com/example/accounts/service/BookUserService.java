package com.example.accounts.service;

import com.example.accounts.bean.BookBean;
import com.example.accounts.bean.BookUserBean;

import java.util.List;

public interface BookUserService {

    List<BookUserBean> getByOwnerId(int userId);
    void addNewRelation(BookUserBean bookUserBean);

}
