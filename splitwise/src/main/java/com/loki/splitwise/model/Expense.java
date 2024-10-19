package com.loki.splitwise.model;

import com.loki.splitwise.model.split.Split;

import java.util.List;
import java.util.Random;

public class Expense {
    private double expenseAmount;
    private String id;
    private String name;
    List<Split> splitDetails;
    ExpenseSplitType splitType;
    User paidByUser;

    private Random random = new Random();
    public Expense(String name, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails ){
        this.id  = generateExpenseId();
        this.name = name;
        this.expenseAmount = expenseAmount;
        this.splitDetails = splitDetails;
        this.splitType = splitType;
        this.paidByUser = paidByUser;
    }

    private String generateExpenseId() {
        long timestamp = System.currentTimeMillis();
        int randomNum = this.random.nextInt(9999);  // Generates a random number to append
        return timestamp + "_" + randomNum;
    }

}
