package com.loki.task.scheduler.exception;

public class TaskAlreadyExistsException  extends RuntimeException {
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
