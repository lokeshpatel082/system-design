package com.loki.splitwise.model;

import com.loki.splitwise.ExpenseService;
import com.loki.splitwise.model.split.Split;
import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    ExpenseService expenseService;

    public Group(String id, String groupName, ExpenseService expenseService){
        this.groupId = id;
        this.groupName = groupName;
        this.groupMembers = new ArrayList<>();
        this.expenseService = expenseService;
    }

    public String addExpence( String description, double expenseAmount,  User paidByUser,
                              List<Split> splitDetails, ExpenseSplitType splitType) {
        Expense expense = expenseService.createExpense(description, expenseAmount, paidByUser,splitType, splitDetails);
        return expense.toString();
    }
    public boolean deleteExpense(String expenseId){
        return false;
    }
    public boolean editExpense(String expenseId, double expenseAmount,  User paidByUser,
                               List<Split> splitDetails, ExpenseSplitType splitType){
        return false;
    }


    //add member to group
    public void addMember(User member){
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
