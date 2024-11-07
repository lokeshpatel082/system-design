package com.loki.logger;

import com.loki.logger.processor.LogProcessor;

public class Logger {
    private volatile static Logger logger;
    private volatile static LogProcessor logProcessor;
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
                }
            }
        }
        return logger;
    }
    public void log(Message message){
      logger.error(message);
    }
    public void log(LogLevel logLevel,Message message){
        createLog(logLevel, message);
    }

    public void error(Message message){
        createLog(LogLevel.ERROR, message);
    }
    public void info(Message message){
        createLog(LogLevel.INFO, message);
    }
    public void debug(Message message){
        createLog(LogLevel.DEBUG, message);
    }

    private void createLog(LogLevel logLevel, Message message){
        logProcessor.logMessage(logLevel, message);
    }


}