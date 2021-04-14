package com.example.accounts.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class RecordBean {

    private int id;
    private int userId;
    private double amount;
    private int isIncome = 0;
    private Date date;
    private int labelId;
    private String remarks;

    public RecordBean() {}
    public RecordBean(int userId, double amount, int isIncome, Date date, int labelId, String remarks) {
        this.userId = userId;
        this.amount = amount < 0 ? (-amount) : amount;
        this.isIncome = isIncome;
        if (date != null)
            this.date = date;
        else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.date = Date.valueOf(df.format(new Date(System.currentTimeMillis())));
        }
        this.labelId = labelId;
        this.remarks = remarks;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public double getAmount() {
        return amount;
    }
    public int getIsIncome() { return isIncome; }
    public Date getDate() { return date; }
    public int getLabelId() {
        return labelId;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setAmount(double amount) {
        this.amount = amount < 0 ? (-amount) : amount;
    }
    public void setIsIncome(int isIncome) { this.isIncome = isIncome; }
    public void setDate(Date date) {
        if (date != null)
            this.date = date;
        else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.date = Date.valueOf(df.format(new Date(System.currentTimeMillis())));
        }
    }
    public void setLabelId(int labelId) { this.labelId = labelId; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

}
