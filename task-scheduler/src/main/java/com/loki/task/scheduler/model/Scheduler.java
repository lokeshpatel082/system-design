package com.loki.task.scheduler.model;

import com.loki.task.scheduler.exception.ConflictingTaskException;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

public class Scheduler {
    private HashMap<String, Task> taskMap;

    public Scheduler(){

    }
    public void createTask(Task task) throws ConflictingTaskException {
        if(taskMap.containsKey(task.getName())){
            throw new IllegalArgumentException("Task already exists. Please delete the existing task first.");
        }

        if(isNonConflictingTask(task)){
            taskMap.put(task.getName(),task);
        }
        else{
            throw new ConflictingTaskException("Conflicting time of the task !!");
        }
    }

    public void deleteTask(Task task){
        if(!taskMap.containsKey(task.getName())){
            throw new IllegalArgumentException(" task not found !!");
        }
        taskMap.remove(task.getName());
    }
   private boolean isNonConflictingTask(Task newTask){
        for(Task task: taskMap.values()){
            if( !(task.getEndTime() < newTask.getStartTime() ||
                task.getStartTime() >= newTask.getEndTime())
            ){
                return false;
            }
        }
        return true;
    }

}
