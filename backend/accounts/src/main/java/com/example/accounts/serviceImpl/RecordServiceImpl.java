package com.example.accounts.serviceImpl;

import com.example.accounts.bean.BookBean;
import com.example.accounts.bean.BookRecordBean;
import com.example.accounts.bean.BookUserBean;
import com.example.accounts.bean.RecordBean;
import com.example.accounts.mapper.RecordMapper;
import com.example.accounts.service.BookRecordService;
import com.example.accounts.service.BookService;
import com.example.accounts.service.BookUserService;
import com.example.accounts.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    //将DAO注入Service层
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookUserService bookUserService;
    @Autowired
    private BookRecordService bookRecordService;

    @Override
    public RecordBean getInfo(int id) {
        return recordMapper.getById(id);
    }

    @Override
    public RecordBean addNewRecord(RecordBean recordBean) {
        recordMapper.insert(recordBean);
        /* 将账单记录添加至对应的月账本中 */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(recordBean.getDate());
        String bookName = calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月的账本";
        BookBean bookBean = bookService.ifBookExists(recordBean.getUserId(), bookName);  //查找是否有对应的月账本
        if (bookBean == null) {    //若未找到，则添加新的月账本
            bookBean = new BookBean();
            bookBean.setName(bookName);
            bookBean.setIsPrivate(1);
            bookService.addNewBook(recordBean.getUserId(), bookBean);
        }
        BookRecordBean bookRecordBean = new BookRecordBean(bookBean.getId(), recordBean.getId());
        bookRecordService.addNewRelation(bookRecordBean);    // 将新记录加入其当月的账本
        return recordBean;
    }

}
