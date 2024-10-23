package com.loki.design.patterns.observer.observables;

import com.loki.design.patterns.observer.NotificationAlertObserver;

public interface StockObservable {
    public void addObserver(NotificationAlertObserver oberserver);
    public void removeObserver(NotificationAlertObserver oberserver);
    public void notifySubscribers();
    public void setStockCount(int stockCount);
}
