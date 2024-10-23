package com.loki.design.patterns.observer;

import com.loki.design.patterns.observer.observables.StockObservable;

public class EmailNotificationAlertImpl implements NotificationAlertObserver{
    private String emailId;
    private StockObservable stockObservable;

    public EmailNotificationAlertImpl(String emailId){
        this.emailId = emailId;
    }
    @Override
    public void update() {
        sendEmail(this.emailId, "product is in the stock hurry up !!");
    }

    private void sendEmail(String emailId, String msg){
        System.out.println("email sent to "+emailId);
        // send actual email
    }

}
