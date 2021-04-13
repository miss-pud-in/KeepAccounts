package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookUserBean;
import com.example.accounts.mapper.BookUserMapper;
import com.example.accounts.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUserServiceImpl implements BookUserService {

    @Autowired
    private BookUserMapper bookUserMapper;

    @Override
    public List<BookUserBean> getByOwnerId(int userId) {
        return bookUserMapper.getByOwnerId(userId);
    }

    @Override
    public void addNewRelation(BookUserBean bookUserBean) {
        bookUserMapper.insert(bookUserBean);
    }

}
