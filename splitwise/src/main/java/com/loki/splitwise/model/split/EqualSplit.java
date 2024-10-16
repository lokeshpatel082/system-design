package com.loki.splitwise.model.split;

import com.loki.splitwise.model.User;

import java.util.List;

public class EqualSplit extends Split{
    public EqualSplit(User user){
        super(user);
    }

    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        return false;
    }
}
