package com.example.accounts.serviceImpl;

import com.example.accounts.bean.RecordBean;
import com.example.accounts.mapper.RecordMapper;
import com.example.accounts.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    //将DAO注入Service层
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public RecordBean getInfo(int id) {
        return recordMapper.getById(id);
    }
}
