package com.example.accounts.bean;

public class BookRecordBean {

    private int bookId;
    private int recordId;

    public BookRecordBean() {}
    public BookRecordBean(int bookId, int recordId) {
        this.bookId = bookId;
        this.recordId = recordId;
    }

    public int getBookId() { return bookId; }
    public int getRecordId() {
        return recordId;
    }

    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

}
