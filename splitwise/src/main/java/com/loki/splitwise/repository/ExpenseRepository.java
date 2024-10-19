package com.loki.splitwise.repository;

import com.loki.splitwise.model.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {
    Map<String, Map<String, Expense>> expenseMap;

    public ExpenseRepository(Map<String, Map<String, Expense>> expenseMap){
        this.expenseMap = expenseMap;
    }

    public String createExpense(String groupId, String expenseId, Expense expense ){
        expenseMap.computeIfAbsent(groupId, k-> new HashMap<>());
        expenseMap.get(groupId).put(expenseId, expense);
        return expenseId;
    }

    public Map<String, Expense> getExpenseMap(String groupId){
        return this.expenseMap.get(groupId);
    }



}
