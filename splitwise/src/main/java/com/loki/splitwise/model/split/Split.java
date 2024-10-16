package com.loki.splitwise.model.split;

import com.loki.splitwise.model.User;

import java.util.List;

public abstract class Split {
    User user;
    double amountOwed;

    public Split(User user){
        this.user = user;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public User getUser() {
        return user;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public abstract boolean validateSplit(List<Split> splitList, double amount);
}
