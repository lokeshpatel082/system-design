package com.loki.task.scheduler.controller;

import com.loki.task.scheduler.exception.ConflictingTaskException;
import com.loki.task.scheduler.service.SchedularService;
import com.loki.task.scheduler.model.Task;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class TaskScheduleController {
    private final SchedularService schedulerService;
    public TaskScheduleController(SchedularService schedulerService){
        this.schedulerService = schedulerService;
    }

    public ResponseEntity<Task> handleCreateTask(Task task) throws ConflictingTaskException {
        try{
            Task createdTask = schedulerService.createTask(task);
            return ResponseEntity.ok(createdTask);
        }
        catch (Exception e){
            return ResponseEntity.badRequest(null, "couldn't create task" + e.getMessage());
        }
    }
    public ResponseEntity<Task> handleDeleteTask(Integer taskId){
        try{
            boolean isDeleted = schedulerService.deleteTask(taskId);
            if(isDeleted){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT,"Task Deleted Successfully !");
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND,"Task Not Found !");
            }
        }
        catch(Exception e){
            return ResponseEntity.badRequest(null, "Error deleting task: " + e.getMessage());
        }

    }
    public ResponseEntity<Task> handleUpdateTask(Integer id, LocalDateTime startTime, LocalDateTime endTime){
        try {
            Task updatedTask = schedulerService.updateTask(id, startTime, endTime);
            return ResponseEntity.ok(updatedTask);
        }
        catch (Exception e){
            return ResponseEntity.badRequest(null, "Error Updating task" + e.getMessage());
        }
    }
}
