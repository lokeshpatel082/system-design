package com.loki.task.scheduler.utils;

import com.loki.task.scheduler.model.Task;

import java.util.Map;

public class TaskSchedulerUtil {
    public static boolean isAnyConflictingTask(Task newTask, Map<Integer, Task> taskMap) {
        for(Task task: taskMap.values()){
            if (TaskSchedulerUtil.isConflictingTask(newTask, task)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isConflictingTask(Task incomingTask, Task existingTask){
        return !(existingTask.getEndTime().isBefore(incomingTask.getStartTime()) ||
                existingTask.getStartTime().isAfter(incomingTask.getEndTime()));
    }
}
