package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookBean;
import com.example.accounts.bean.LabelBean;
import com.example.accounts.bean.UserBean;
import com.example.accounts.mapper.UserMapper;
import com.example.accounts.service.BookService;
import com.example.accounts.service.LabelService;
import com.example.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookService bookService;
    @Autowired
    private LabelService labelService;

    @Override
    public String login(String name, String password) {
        UserBean userBean = userMapper.getByName(name);
        if (userBean == null) {
            return "0";  // 用户不存在
        }
        else if (userBean.getPassword().equals(password)) {
            return "2";  // 登录成功
        }
        else {
            return "1";  // 密码错误
        }
    }

    @Override
    public String register(String name, String password) {
        UserBean userBean = userMapper.getByName(name);
        if (userBean != null) {
            return "0";  // 用户名已存在
        }
        else {
            /* 添加用户 */
            userBean = new UserBean();
            userBean.setName(name);
            userBean.setPassword(password);
            userMapper.insert(userBean);
            /* 为新用户添加当月账本 */
            Calendar calendar = Calendar.getInstance();
            BookBean bookBean = new BookBean();
            bookBean.setName(calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月的账本");
            bookBean.setIsPrivate(1);
            bookService.addNewBook(userBean.getId(), bookBean);
            /* 为新用户添加默认标签 */
            LabelBean labelBean = new LabelBean(userBean.getId(), "无", 0);
            labelService.addNewLabel(labelBean);
            return "1";  // 注册成功
        }
    }

    @Override
    public UserBean getInfo(String name) {
        return userMapper.getByName(name);
    }

}
