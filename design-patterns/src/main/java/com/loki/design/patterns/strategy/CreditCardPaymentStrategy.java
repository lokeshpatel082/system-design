package com.loki.design.patterns.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    private String cardNo;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPaymentStrategy(String cardNo, String cardHolderName, String cvv, String expiryDate){
        this.cardHolderName = cardHolderName;
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount  + " paid by credit/debit card");
    }
}
