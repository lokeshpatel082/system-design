package com.loki.splitwise;

import com.loki.splitwise.model.ExpenseSplitType;
import com.loki.splitwise.model.Expense;
import com.loki.splitwise.model.User;
import com.loki.splitwise.model.split.Split;
import com.loki.splitwise.repository.ExpenseRepository;

import java.util.List;
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(String name, double amount,User paidByUser,  ExpenseSplitType splitType, List<Split>splitDetails ){

        switch (splitType){
            case EQUAL:
                setEqualAmount(splitDetails, amount);
                return new Expense(name, amount, paidByUser, splitType, splitDetails);
            case UNEQUAL:

        }



        return null;
    }

    private void setEqualAmount(List<Split> splitList, double amount){
        double totalSplitSize = splitList.size();
        double amountPerShare = amount/totalSplitSize;

        for(Split split: splitList){
            split.setAmountOwed(amountPerShare);
        }
    }
}
