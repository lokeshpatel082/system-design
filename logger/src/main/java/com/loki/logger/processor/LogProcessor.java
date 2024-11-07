package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.Message;
import lombok.Setter;

public abstract class LogProcessor {
    protected LogLevel level;
    @Setter
    protected LogProcessor nextLogProcessor;

    protected LogProcessor(LogLevel logLevel){
        this.level = logLevel;
    }
    public void logMessage(LogLevel logLevel, Message message) {
        if(this.level.getValue() <= logLevel.getValue()){
            this.displayMessage(message);
        }
        if(this.nextLogProcessor != null){
            this.nextLogProcessor.logMessage(logLevel, message);
        }
    }

    protected abstract void displayMessage(Message message);
}
