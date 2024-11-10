package com.loki.logger;

import java.util.*;

public class LogObservable {
    private Map<LogLevel, List<LogObserver>> logObservers;
    public LogObservable(){
        this.logObservers = new EnumMap<>(LogLevel.class);
    }

    public void addObserver(LogLevel logLevel, LogObserver observer){
        List<LogObserver> observerList = logObservers.getOrDefault(logLevel, new ArrayList<>());
        observerList.add(observer);
        logObservers.put(logLevel,observerList);
    }
    public void removeObserver(LogLevel logLevel, LogObserver observer){
        this.logObservers.get(logLevel).remove(observer);
    }

    public void notifyAllObservers(LogLevel level, Log log){
        for(Map.Entry<LogLevel,List<LogObserver>> entry: logObservers.entrySet()){
            if(level.equals(entry.getKey())){
                entry.getValue().forEach((observer -> observer.writeMessage(log)));
            }

        }

    }


}
