package com.loki.task.scheduler.io;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskSchedulerIO {
    private final Scanner scanner;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public TaskSchedulerIO() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Create a task");
        System.out.println("2. Update a task");
        System.out.println("3. Delete a task");
        System.out.println("4. Exit");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public String getTaskName() {
        System.out.print("Enter task name: ");
        String name = scanner.next();
        return name;
    }

    public LocalDateTime getStartDateTime() {
        System.out.println("Enter start time (format: yyyy-MM-dd'T'HH:mm): ");
        String startTime = scanner.next();
        return LocalDateTime.parse(startTime,formatter);
    }

    public LocalDateTime getEndDateTime() {
        System.out.println("Enter end time (format: yyyy-MM-dd'T'HH:mm): ");
        String endTime = scanner.next();
        return LocalDateTime.parse(endTime,formatter);
    }
    public Integer getTaskId(){
        System.out.print("Enter task id: ");
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        scanner.close();
    }
}
