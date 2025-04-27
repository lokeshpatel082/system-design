package com.loki.logger.logobserverImpl;

import com.loki.logger.LogObserver;
import com.loki.logger.Log;

public class File implements LogObserver {
    @Override
    public void writeMessage(Log log) {
        System.out.println("Write msg to file => " + log.getMessage() + " " + log.getTimestamp());
    }
}
