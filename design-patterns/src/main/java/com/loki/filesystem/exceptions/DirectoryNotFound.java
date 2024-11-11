package com.loki.filesystem.exceptions;

public class DirectoryNotFound extends RuntimeException {
    public DirectoryNotFound(String message) {
        super(message);
    }
}
