package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.Message;
import lombok.Setter;

public class ErrorLogProcessor extends LogProcessor{

    public ErrorLogProcessor(LogLevel logLevel){
        super(logLevel);
    }
    protected void displayMessage( Message message){
        System.out.println("ERROR: " + message.getMessageDescription() + " at " + message.getTimestamp());
    }
}
