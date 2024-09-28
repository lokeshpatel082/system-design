package com.loki.task.scheduler.model;

import java.util.UUID;

public class Task {
    private String name;
    private long startTime;
    private long endTime;


    public Task(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public long getStartTime(){
        return this.startTime;
    }
    public long getEndTime(){
        return this.endTime;
    }

}
