package com.loki.logger;

import lombok.Getter;

public enum LogLevel {

    ERROR(1),
    INFO(2),
    DEBUG(3);

    @Getter
    private final int value;
    LogLevel(int logLevel){
        this.value = logLevel;
    }
}
