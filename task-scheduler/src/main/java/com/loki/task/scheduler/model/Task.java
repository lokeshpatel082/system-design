package com.loki.task.scheduler.model;
import lombok.Setter;

import java.time.LocalDateTime;

public class Task {
    private final String name;
    @Setter
    private Integer id;
    @Setter
    private LocalDateTime startTime;
    @Setter
    private LocalDateTime endTime;

    public Task(String name, LocalDateTime startTime, LocalDateTime endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getName(){
        return this.name;
    }
    public LocalDateTime getStartTime(){
        return this.startTime;
    }
    public LocalDateTime getEndTime(){
        return this.endTime;
    }

    public Integer getId(){
        return this.id;
    }

}
