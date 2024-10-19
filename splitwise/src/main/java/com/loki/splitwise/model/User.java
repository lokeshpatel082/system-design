package com.loki.splitwise.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String userId;
    Map<User, Double> expenseBalanceSheet;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
        this.expenseBalanceSheet = new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<User, Double> getExpenseBalanceSheet() {
        return expenseBalanceSheet;
    }

    public void updateBalanceSheet(User paidByUser, double amount){
        expenseBalanceSheet.computeIfAbsent(paidByUser, k->0.0);
        expenseBalanceSheet.computeIfPresent(paidByUser, (k, prevVal)-> prevVal + amount);
    }
}
