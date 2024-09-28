package com.loki.task.scheduler.model;

import java.util.UUID;

public class Task {
    private String name;
    private UUID id;

    public Task(String name){
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName(){
        return this.name;
    }

}
