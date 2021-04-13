package com.example.accounts.bean;

public class BookUserBean {

    private int bookId;
    private int userId;
    private int isOwner = 0;

    public BookUserBean() {}
    public BookUserBean(int bookId, int userId, int isOwner) {
        this.bookId = bookId;
        this.userId = userId;
        if (isOwner == 0 || isOwner == 1)
            this.isOwner = isOwner;
    }

    public int getBookId() {
        return bookId;
    }
    public int getUserId() {
        return userId;
    }
    public int getIsOwner() { return isOwner; }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setIsOwner(int isOwner) { this.isOwner = isOwner; }

}
