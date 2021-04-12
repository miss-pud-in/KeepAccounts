package com.example.accounts.mapper;

import com.example.accounts.bean.RecordBean;

public interface RecordMapper {

    RecordBean getById(int id);
    void insert(RecordBean recordBean);
    void update(RecordBean recordBean);

}
