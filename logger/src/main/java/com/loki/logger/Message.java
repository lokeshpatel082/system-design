package com.loki.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message {
    private String messageDescription;
    private long timestamp;
}
