package com.loki.logger;

import com.loki.logger.logobserverImpl.Console;
import com.loki.logger.logobserverImpl.File;

public class Main {
    public static void main(String[] args){

        Logger logger = Logger.getInstance();

        Logger.setLogLevel(LogLevel.DEBUG);

        LogObserver consoleObserver = new Console();
        logger.addObserver(LogLevel.INFO,consoleObserver);
        logger.addObserver(LogLevel.DEBUG,consoleObserver);
        logger.addObserver(LogLevel.ERROR,consoleObserver);

        LogObserver fileObserver = new File();
        logger.addObserver(LogLevel.ERROR, fileObserver);


        logger.error("error message");
        logger.log("some other error message");
        logger.info("info message");
        logger.debug("debug message");
    }
}