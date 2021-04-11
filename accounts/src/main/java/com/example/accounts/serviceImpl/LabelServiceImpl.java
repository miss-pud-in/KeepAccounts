package com.example.accounts.serviceImpl;

import com.example.accounts.bean.LabelBean;
import com.example.accounts.mapper.LabelMapper;
import com.example.accounts.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public void addNewLabel(int userId, String name) {
        LabelBean labelBean = new LabelBean();
        labelBean.setUserId(userId);
        labelBean.setName(name);
        labelMapper.insert(labelBean);
    }

}
