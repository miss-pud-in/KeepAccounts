package com.example.accounts.service;

import com.example.accounts.bean.LabelBean;

import java.util.List;

public interface LabelService {

    List<LabelBean> getByUserId(int userId);
    boolean addNewLabel(LabelBean labelBean);
    boolean ifLabelExists(LabelBean labelBean);

}
