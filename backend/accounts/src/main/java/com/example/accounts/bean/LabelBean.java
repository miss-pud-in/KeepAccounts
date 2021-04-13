package com.example.accounts.bean;

public class LabelBean {

    private int id;
    private int userId;
    private String name;
    private int isFavorite = 0;

    public LabelBean() {}
    public LabelBean(int userId, String name, int isFavorite) {
        this.userId = userId;
        this.name = name;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public int getIsFavorite() {
        return isFavorite;
    }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

}
