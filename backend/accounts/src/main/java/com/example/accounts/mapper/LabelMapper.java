package com.example.accounts.mapper;

import com.example.accounts.bean.LabelBean;

public interface LabelMapper {

    LabelBean getById(int id);
    void insert(LabelBean labelBean);
    void update(LabelBean labelBean);
    void delete(int id);

}
