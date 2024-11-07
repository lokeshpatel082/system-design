package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.Message;
import lombok.Setter;
public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogLevel logLevel){
        super(logLevel);
    }
    protected void displayMessage( Message message){
        System.out.println("INFO: " + message.getMessageDescription() + " at " + message.getTimestamp());
    }

}
