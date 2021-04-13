package com.example.accounts.mapper;

import com.example.accounts.bean.LabelBean;

import java.util.List;

public interface LabelMapper {

    LabelBean getById(int id);
    List<LabelBean> getByUserId(int userId);
    LabelBean getByUserAndName(LabelBean labelBean);
    void insert(LabelBean labelBean);
    void update(LabelBean labelBean);
    void delete(int id);

}
