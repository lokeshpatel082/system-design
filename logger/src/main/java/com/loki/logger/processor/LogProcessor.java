package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.LogObservable;
import com.loki.logger.Log;
import com.loki.logger.Logger;
import lombok.Setter;

import java.time.LocalDateTime;

public abstract class LogProcessor {
    protected LogLevel level;
    @Setter
    protected LogProcessor nextLogProcessor;

    protected LogProcessor(LogLevel logLevel){
        this.level = logLevel;
    }
    public void logMessage(LogLevel logLevel, String message, LogObservable logObservable) {
        if(this.level.equals(logLevel) && logLevel.getValue() <= Logger.getLogLevel().getValue()){
            Log log = new Log("["+this.level.name() + "] : "+ message, LocalDateTime.now());
            this.displayMessage(log, logObservable);
        }
        if(this.nextLogProcessor != null){
            this.nextLogProcessor.logMessage(logLevel, message, logObservable);
        }
    }

    protected abstract void displayMessage(Log message, LogObservable logObservable);
}
