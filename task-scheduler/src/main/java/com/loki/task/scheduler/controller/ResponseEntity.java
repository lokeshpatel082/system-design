package com.loki.task.scheduler.controller;

import org.springframework.http.HttpStatus;

public class ResponseEntity<T>{
    private HttpStatus status;
    private T body;
    private String message;
    public ResponseEntity(T body, HttpStatus status, String message) {
        this.status = status;
        this.body = body;
        this.message = message;
    }

    // Getters
    public HttpStatus getStatus() {
        return status;
    }

    public T getBody() {
        return body;
    }

    public String getMessage() {
        return message;
    }

    // Static factory methods for convenience
    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK, "Success");
    }

    public static <T> ResponseEntity<T> badRequest(T body, String message) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST, message);
    }

}
