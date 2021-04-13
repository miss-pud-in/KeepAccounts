package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookBean;
import com.example.accounts.bean.BookUserBean;
import com.example.accounts.mapper.BookMapper;
import com.example.accounts.service.BookService;
import com.example.accounts.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookUserService bookUserService;

    @Override
    public BookBean getBookById(int id) {
        return bookMapper.getById(id);
    }

    @Override
    public List<BookBean> getByUserId(int userId) {
        List<BookUserBean> bookUserBeanList = bookUserService.getByOwnerId(userId);
        List<BookBean> bookBeanList = new ArrayList<BookBean>();
        for (BookUserBean bean : bookUserBeanList) {
            bookBeanList.add(bookMapper.getById(bean.getBookId()));
        }
        return bookBeanList;
    }

    @Override
    public void addNewBook(int userId, BookBean bookBean) {
        bookMapper.insert(bookBean);
        BookUserBean bookUserBean = new BookUserBean(bookBean.getId(), userId, 1);
        bookUserService.addNewRelation(bookUserBean);
    }

}
