package com.loki.task.scheduler.commands;

import com.loki.task.scheduler.controller.ResponseEntity;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.io.TaskSchedulerIO;
import com.loki.task.scheduler.model.Task;
import org.springframework.http.HttpStatus;

public class DeleteCommand implements Command{
    private final TaskScheduleController taskScheduleController;
    private final TaskSchedulerIO taskSchedulerIO;

    public DeleteCommand(TaskSchedulerIO taskSchedulerIO, TaskScheduleController taskScheduleController) {
        this.taskScheduleController = taskScheduleController;
        this.taskSchedulerIO = taskSchedulerIO;
    }
    @Override
    public void execute() {
        Integer taskId = taskSchedulerIO.getTaskId();
        try{
            ResponseEntity<Task> taskResponseEntity = taskScheduleController.handleDeleteTask(taskId);
            if(taskResponseEntity.getStatus() == HttpStatus.NO_CONTENT){
                System.out.println(taskResponseEntity.getMessage());
            }
            else {
                System.out.println(taskResponseEntity.getMessage());
            }
        }
        catch (Exception e){
            System.out.println("could not delete task "+ e.getMessage());
        }
    }
}
