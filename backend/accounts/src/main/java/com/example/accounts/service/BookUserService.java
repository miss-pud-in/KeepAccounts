package com.example.accounts.service;

import com.example.accounts.bean.BookUserBean;

public interface BookUserService {

    void addNewRelation(int bookId, int userId, boolean isOwner);

}
