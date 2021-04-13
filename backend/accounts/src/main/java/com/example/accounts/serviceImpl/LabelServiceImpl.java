package com.example.accounts.serviceImpl;

import com.example.accounts.bean.LabelBean;
import com.example.accounts.mapper.LabelMapper;
import com.example.accounts.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<LabelBean> getByUserId(int userId) {
        return labelMapper.getByUserId(userId);
    }

    @Override
    public boolean addNewLabel(LabelBean labelBean) {
        if (!ifLabelExists(labelBean)) {
            labelMapper.insert(labelBean);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean ifLabelExists(LabelBean labelBean) {
        LabelBean bean = labelMapper.getByUserAndName(labelBean);
        if (bean != null)
            return true;
        else
            return false;
    }

}
