package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookBean;
import com.example.accounts.mapper.BookMapper;
import com.example.accounts.service.BookService;
import com.example.accounts.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookUserService bookUserService;

    @Override
    public void addNewBook(int userId, String name, boolean isMonthly) {
        BookBean bookBean = new BookBean();
        if (isMonthly) {
            Calendar calendar = Calendar.getInstance();
            // String year = String.valueOf(calendar.get(Calendar.YEAR));
            int year = calendar.get(Calendar.YEAR);
            // String month = String.valueOf(calendar.get(Calendar.MONTH));
            int month = calendar.get(Calendar.MONTH);
            bookBean.setName(year + "年" + month + "月的账本");
            bookBean.setIsPrivate(1);
        }
        else {
            bookBean.setName(name);
        }
        bookMapper.insert(bookBean);
        bookUserService.addNewRelation(bookBean.getId(), userId, true);
    }

}
