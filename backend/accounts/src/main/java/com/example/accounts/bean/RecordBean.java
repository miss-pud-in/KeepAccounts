package com.example.accounts.bean;

import java.util.Date;

public class RecordBean {

    private int id;
    private double amount;
    private Date date;
    private String labelId;
    private String remarks;

    public int getId() { return id; }
    public double getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }
    public String getLabelId() {
        return labelId;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setId(int id) { this.id = id; }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
