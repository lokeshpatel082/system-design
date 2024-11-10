package com.loki.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Log {
    private String message;
    private LocalDateTime timestamp;
}
