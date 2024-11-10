package com.loki.logger;

import com.loki.logger.processor.LogProcessor;
import lombok.Getter;
import lombok.Setter;

public class Logger {
    @Getter
    @Setter
    private volatile static LogLevel logLevel;
    private volatile static Logger logger;
    private volatile static LogProcessor logProcessor;
    private volatile static LogObservable logObservable;
    private Logger(){
        if (logger != null)
            throw new IllegalStateException("Object already created");
    }
    public static Logger getInstance(){
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    logProcessor = LogManager.makeChain();
                    logLevel = LogLevel.DEBUG;
                    logObservable = new LogObservable();
                }
            }
        }
        return logger;
    }
    public void addObserver(LogLevel logLevel, LogObserver observer){
        logObservable.addObserver(logLevel,observer);
    }
    public void removeObserver(LogLevel logLevel, LogObserver observer){
        logObservable.removeObserver(logLevel,observer);
    }
    public void log(String logMessage){
      logger.error(logMessage);
    }
    public void log(LogLevel logLevel,String message){
        createLog(logLevel, message);
    }

    public void error(String message){
        createLog(LogLevel.ERROR, message);
    }
    public void info(String message){
        createLog(LogLevel.INFO, message);
    }
    public void debug(String message){
        createLog(LogLevel.DEBUG, message);
    }

    private void createLog(LogLevel logLevel, String message){
        logProcessor.logMessage(logLevel, message, logObservable);
    }


}