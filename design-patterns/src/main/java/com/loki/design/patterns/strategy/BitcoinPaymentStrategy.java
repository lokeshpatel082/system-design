package com.loki.design.patterns.strategy;

public class BitcoinPaymentStrategy implements PaymentStrategy{
    private String bitcoinPaymentAdress;

    public BitcoinPaymentStrategy(String bitcoinPaymentAdress){
        this.bitcoinPaymentAdress = bitcoinPaymentAdress;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using bitcoin");
    }
}
