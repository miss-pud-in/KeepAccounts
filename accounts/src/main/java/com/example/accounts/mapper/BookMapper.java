package com.example.accounts.mapper;

import com.example.accounts.bean.BookBean;

public interface BookMapper {

    BookBean getById(int id);
    void insert(BookBean bookBean);
    void update(BookBean bookBean);
    void delete(int id);
}
