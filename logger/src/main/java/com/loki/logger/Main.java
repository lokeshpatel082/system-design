package com.loki.logger;

public class Main {
    public static void main(String[] args){

        Logger logger = Logger.getInstance();
        logger.error(new Message("error message ", 23));
        logger.info(new Message("info message ", 12));
        logger.debug(new Message("debug message ", 890));
    }
}