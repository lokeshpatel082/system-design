package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.LogObservable;
import com.loki.logger.Log;

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogLevel level){
        super(level);
    }
    protected void displayMessage(Log log, LogObservable logObservable){
        logObservable.notifyAllObservers(this.level, log);
    }

}
