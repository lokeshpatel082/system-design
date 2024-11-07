package com.loki.logger.processor;

import com.loki.logger.LogLevel;
import com.loki.logger.Message;
import lombok.Setter;

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogLevel level){
        super(level);
    }
    protected void displayMessage( Message message){
        System.out.println("DEBUG: " + message.getMessageDescription() + " at " + message.getTimestamp());
    }

}
