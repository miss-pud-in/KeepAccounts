package com.example.accounts.controller;

import com.example.accounts.bean.LabelBean;
import com.example.accounts.bean.UserBean;
import com.example.accounts.service.LabelService;
import com.example.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LabelController {

    @Autowired
    LabelService labelService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getLabels",method = RequestMethod.POST)
    public Object getLabels(@RequestParam(value = "username") String username) {
        UserBean userBean = userService.getInfo(username);
        List<LabelBean> labelBeanList = labelService.getByUserId(userBean.getId());
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List>(labelBeanList, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/addLabel",method = RequestMethod.POST)
    public void addLabel(@RequestParam(value = "username") String username,@RequestParam(value = "labelName") String name) {
        UserBean userBean = userService.getInfo(username);
        LabelBean labelBean = new LabelBean(userBean.getId(), name, 0);
        labelService.addNewLabel(labelBean);
    }

}