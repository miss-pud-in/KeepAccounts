package com.example.accounts.service;

import com.example.accounts.bean.RecordBean;

import java.sql.Date;

public interface RecordService {

    RecordBean getInfo(int id);
    RecordBean addNewRecord(RecordBean recordBean);

}
