package com.example.accounts.bean;

public class UserBean {

    //属性名与数据表的字段名必须一致
    private int id;
    private String name;
    private String password;
    private int budgetForMonth = 0;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getBudgetForMonth() {
        return budgetForMonth;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBudgetForMonth(int budgetForMonth) {
        if(budgetForMonth >= 0)
            this.budgetForMonth = budgetForMonth;
    }

}
