package com.loki.task.scheduler.commands;

import com.loki.task.scheduler.controller.ResponseEntity;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.io.TaskSchedulerIO;
import com.loki.task.scheduler.model.Task;

import java.time.LocalDateTime;

public class CreateCommand implements Command {

    private final TaskScheduleController taskScheduleController;
    private final TaskSchedulerIO taskSchedulerIO;

    public CreateCommand(TaskSchedulerIO taskSchedulerIO, TaskScheduleController taskScheduleController) {
        this.taskScheduleController = taskScheduleController;
        this.taskSchedulerIO = taskSchedulerIO;
    }

    @Override
    public void execute() {
        Task newTask = this.createTask();
        try{
            ResponseEntity<Task> taskResponseEntity = taskScheduleController.handleCreateTask(newTask);
            if(taskResponseEntity.getBody() == null){
                System.out.println(taskResponseEntity.getMessage());
            }
            else {
                System.out.println(taskResponseEntity.getMessage() + taskResponseEntity.getBody());
            }
        }
        catch (Exception e){
            System.out.println("bad request "+ e.getMessage());
        }

    }
    private Task createTask(){
        String name = taskSchedulerIO.getTaskName();
        LocalDateTime startTime = taskSchedulerIO.getStartDateTime();
        LocalDateTime endTime = taskSchedulerIO.getEndDateTime();
        return new Task(name,startTime,endTime);
    }
}
