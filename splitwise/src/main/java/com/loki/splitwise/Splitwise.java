package com.loki.splitwise;

import com.loki.splitwise.model.Expense;
import com.loki.splitwise.model.User;
import com.loki.splitwise.repository.ExpenseRepository;

import java.util.HashMap;
import java.util.Map;

public class Splitwise {
    GroupController groupController;

    public Splitwise(){
        Map<String, Map<String , Expense>> groupWiseExpenseList = new HashMap<>();
        ExpenseRepository expenseRepository = new ExpenseRepository(groupWiseExpenseList);
        ExpenseService expenseService = new ExpenseService(expenseRepository);
        groupController = new GroupController(expenseService);
    }

    public void setupUserAndGroup(){

        addUsersToSplitwiseApp();

        //create a group by user1
        groupController.createGroup("G1001", "Outing with Friends");
    }

    private void addUsersToSplitwiseApp(){

        //adding User1
        User user1 = new User("U1001", "User1");

        //adding User2
        User user2 = new User ("U2001", "User2");

        //adding User3
        User user3 = new User ("U3001", "User3");


    }


}
