package com.example.accounts.bean;

public class MessageBean {

    private int id;
    private int from;
    private int to;
    private int type;

    public int getId() {
        return id;
    }
    public int getFrom() {
        return from;
    }
    public int getTo() {
        return to;
    }
    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFrom(int from) {
        this.from = from;
    }
    public void setTo(int to) {
        this.to = to;
    }
    public void setType(int type) {
        this.type = type;
    }
}
