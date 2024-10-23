package com.loki.design.patterns.observer;

import com.loki.design.patterns.observer.observables.StockObservable;

public class MsgNotificationAlertImpl implements NotificationAlertObserver{
    private String userName;
    StockObservable stockObservable;
    public MsgNotificationAlertImpl(String userName){
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMessage(userName,"the product is in the stock, Hurry up !!");
    }

    private void sendMessage(String userName, String msg){
        System.out.println("message sent to " + userName);
    }
}
