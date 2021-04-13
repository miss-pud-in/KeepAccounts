package com.example.accounts.mapper;

import com.example.accounts.bean.BookUserBean;

import java.util.List;

public interface BookUserMapper {

    List<BookUserBean> getByUserId(int userId);
    List<BookUserBean> getByOwnerId(int userId);
    void insert(BookUserBean bookUserBean);

}
