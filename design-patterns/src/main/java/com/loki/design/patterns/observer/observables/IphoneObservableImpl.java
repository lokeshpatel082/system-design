package com.loki.design.patterns.observer.observables;

import com.loki.design.patterns.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    private List<NotificationAlertObserver> observerList = new ArrayList<>();
    private int stockCount = 0;

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : observerList){
            observer.update();
        }
    }

    public void setStockCount(int stockCount){
        if(this.stockCount == 0){
            notifySubscribers();
        }
        this.stockCount = stockCount;
    }

    public int getStockCount(){
        return this.stockCount;
    }
}
