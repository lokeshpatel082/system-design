package com.loki.design.patterns.observer;

import com.loki.design.patterns.observer.observables.IphoneObservableImpl;
import com.loki.design.patterns.observer.observables.StockObservable;

public class ObserverDesignPatternDemo {
    public static void main(String[] args){
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailNotificationAlertImpl("abs@gmail.com");
        NotificationAlertObserver observer2 = new EmailNotificationAlertImpl("akjdfla@gmail.com");
        NotificationAlertObserver observer3 = new MsgNotificationAlertImpl("abs@gmail.com");

        iphoneStockObservable.addObserver(observer1);
        iphoneStockObservable.addObserver(observer2);
        iphoneStockObservable.addObserver(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
