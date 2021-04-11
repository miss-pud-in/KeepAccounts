package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookUserBean;
import com.example.accounts.mapper.BookUserMapper;
import com.example.accounts.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserServiceImpl implements BookUserService {

    @Autowired
    private BookUserMapper bookUserMapper;

    @Override
    public void addNewRelation(int bookId, int userId, boolean isOwner) {
        BookUserBean bookUserBean = new BookUserBean();
        bookUserBean.setBookId(bookId);
        bookUserBean.setUserId(userId);
        if (isOwner) {
            bookUserBean.setIsOwner(1);
        }
        bookUserMapper.insert(bookUserBean);
    }

}
