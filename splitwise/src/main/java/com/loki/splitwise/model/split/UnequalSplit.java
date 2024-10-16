package com.loki.splitwise.model.split;

import com.loki.splitwise.model.User;

import java.util.List;

public class UnequalSplit extends Split{
    public UnequalSplit(User user, double amount){
        super(user);
        this.amountOwed = amount;
    }

    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double totalAmount = 0;
        for(Split split: splitList){
            totalAmount += split.getAmountOwed();
        }
        return totalAmount == amount;
    }
}
