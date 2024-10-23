package com.loki.design.patterns.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public ShoppingCart(){
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public void checkout(int amount){
        paymentStrategy.pay(amount);
    }
}
