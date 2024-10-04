package com.loki.task.scheduler.commands;

import com.loki.task.scheduler.controller.ResponseEntity;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.io.TaskSchedulerIO;
import com.loki.task.scheduler.model.Task;

import java.time.LocalDateTime;

public class UpdateCommand implements Command {

    private final TaskScheduleController taskScheduleController;
    private final TaskSchedulerIO taskSchedulerIO;

    public UpdateCommand(TaskSchedulerIO taskSchedulerIO, TaskScheduleController taskScheduleController) {
        this.taskScheduleController = taskScheduleController;
        this.taskSchedulerIO = taskSchedulerIO;
    }

    @Override
    public void execute() {
        Integer id = taskSchedulerIO.getTaskId();
        LocalDateTime newStartTime = taskSchedulerIO.getStartDateTime();
        LocalDateTime newEndTime = taskSchedulerIO.getEndDateTime();

        try{
            ResponseEntity<Task> taskResponseEntity = taskScheduleController.handleUpdateTask(id,newStartTime,newEndTime);
            if(taskResponseEntity.getBody() == null){
                System.out.println(taskResponseEntity.getMessage());
            }
            else{
                System.out.println("Updated task successfully" + taskResponseEntity.getBody());
            }

        }
        catch (Exception e){
            System.out.println("could not update task "+ e.getMessage());
        }

    }
}
