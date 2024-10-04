package com.loki.task.scheduler;

import com.loki.task.scheduler.commands.CommandManager;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.model.Task;
import com.loki.task.scheduler.repository.TaskRepository;
import com.loki.task.scheduler.service.impl.SchedulerServiceImpl;
import com.loki.task.scheduler.io.TaskSchedulerIO;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)  {
        Map<Integer, Task> taskMap = new HashMap<>();
        TaskRepository taskRepository = new TaskRepository(taskMap);
        SchedulerServiceImpl schedulerService = new SchedulerServiceImpl(taskRepository);
        TaskScheduleController taskScheduleController = new TaskScheduleController(schedulerService);
        TaskSchedulerIO taskSchedulerIO = new TaskSchedulerIO();

        CommandManager commandManager = new CommandManager(taskSchedulerIO, taskScheduleController);
        commandManager.run();
    }
}