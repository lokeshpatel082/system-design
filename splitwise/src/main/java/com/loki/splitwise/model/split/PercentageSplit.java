package com.loki.splitwise.model.split;

import com.loki.splitwise.model.User;

import java.util.List;

public class PercentageSplit extends Split{
    private double percent;
    public PercentageSplit(User user, double percent){
        super(user);
        this.percent = percent;
    }

    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double percentageSum = 0;
        for (Split split : splitList) {
            if (!(split instanceof PercentageSplit)) return false;
            percentageSum += ((PercentageSplit) split).percent;
            double sharedAmount = (amount * ((PercentageSplit) split).percent) / 100.0;
            split.setAmountOwed(sharedAmount);
        }
        return percentageSum == 100;
    }
}
