package com.example.accounts.bean;

public class MessageBean {

    private int id;
    private int fromId;
    private int toId;
    private int type;
    private String[] contentList = {
            "欢迎你成为我们网站的第" + (toId - 100000) + "名用户！/n以下是一份使用指南，以便你更快地了解我们的的网站：/n"
    };

    public MessageBean() {}
    public MessageBean(int fromId, int toId, int type) {
        this.fromId = fromId;
        this.toId = toId;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public int getFromId() {
        return fromId;
    }
    public int getToId() {
        return toId;
    }
    public int getType() {
        return type;
    }
    public String getContent() {
        if (type < contentList.length && type >= 0)
            return contentList[type];
        return null;
    }

    public void setId(int id) { this.id = id; }
    public void setFromId(int fromId) {
        this.fromId = fromId;
    }
    public void setToId(int toId) {
        this.toId = toId;
    }
    public void setType(int type) {
        this.type = type;
    }

}
