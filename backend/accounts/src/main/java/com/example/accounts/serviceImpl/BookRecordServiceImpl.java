package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookRecordBean;
import com.example.accounts.mapper.BookRecordMapper;
import com.example.accounts.service.BookRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRecordServiceImpl implements BookRecordService {

    @Autowired
    private BookRecordMapper bookRecordMapper;

    @Override
    public void addNewRelation(BookRecordBean bookRecordBean) {
        bookRecordMapper.insert(bookRecordBean);
    }

}
