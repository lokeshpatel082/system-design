package com.loki.logger;

import com.loki.logger.processor.DebugLogProcessor;
import com.loki.logger.processor.ErrorLogProcessor;
import com.loki.logger.processor.InfoLogProcessor;
import com.loki.logger.processor.LogProcessor;

public class LogManager {
    public static LogProcessor makeChain(){
        LogProcessor errorLogProcessor = new ErrorLogProcessor(LogLevel.ERROR);
        LogProcessor infoLogProcessor = new InfoLogProcessor(LogLevel.INFO);
        LogProcessor debugLogProcessor = new DebugLogProcessor(LogLevel.DEBUG);

        infoLogProcessor.setNextLogProcessor(debugLogProcessor);
        errorLogProcessor.setNextLogProcessor(infoLogProcessor);

        return errorLogProcessor;
    }
}
