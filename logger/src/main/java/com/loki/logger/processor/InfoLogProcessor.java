package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.LogObservable;
import com.loki.logger.Log;
public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogLevel logLevel){
        super(logLevel);
    }
    protected void displayMessage(Log message, LogObservable logObservable){
        logObservable.notifyAllObservers(this.level, message);
    }

}
