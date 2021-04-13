package com.example.accounts.bean;

public class BookBean {

    private int id;
    private String name;
    private int isPrivate = 0;
    private int isLock = 0;
    private String password;
    private int isDeletable = 0;
    private String description;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getIsPrivate() {
        return isPrivate;
    }
    public int getIsLock() {
        return isLock;
    }
    public String getPassword() {
        return password;
    }
    public int getIsDeletable() { return isDeletable; }
    public String getDescription() { return description; }

    public void setName(String name) {
        this.name = name;
    }
    public void setIsPrivate(int isPrivate) {
        this.isPrivate = isPrivate;
    }
    public void setIsLock(int isLock) {
        this.isLock = isLock;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setIsDeletable(int isDeletable) { this.isDeletable = isDeletable; }
    public void setDescription(String description) { this.description = description; }

}
