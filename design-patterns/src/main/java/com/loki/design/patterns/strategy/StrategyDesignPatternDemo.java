package com.loki.design.patterns.strategy;

public class StrategyDesignPatternDemo {

    public static void main(String[] args){
        PaymentStrategy paymentStrategy1 = new CreditCardPaymentStrategy("89XXXX90","Lokesh","897","89-90-90");
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(paymentStrategy1);
        cart.checkout(100);

        PaymentStrategy paymentStrategy2 = new PaypalPaymentStrategy("userName","0q9834093843");
        cart.setPaymentStrategy(paymentStrategy2);
        cart.checkout(100);

        PaymentStrategy paymentStrategy3 = new BitcoinPaymentStrategy("0q9834093843");
        cart.setPaymentStrategy(paymentStrategy3);
        cart.checkout(100);
    }
}
