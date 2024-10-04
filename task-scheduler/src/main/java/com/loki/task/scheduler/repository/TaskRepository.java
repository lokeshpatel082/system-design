package com.loki.task.scheduler.repository;

import com.loki.task.scheduler.exception.TaskNotFoundException;
import com.loki.task.scheduler.model.Task;

import java.util.Map;
import java.util.Optional;

public class TaskRepository implements BaseRepository<Task> {
    private final Map<Integer, Task> taskMap;
    public TaskRepository(Map<Integer, Task> taskMap){
        this.taskMap = taskMap;
    }

    public Task create(Task task) {
        Integer id = this.taskMap.size() + 1;
        task.setId(id);
        taskMap.put(id, task);
        return task;
    }

    public Optional<Task> get(Integer taskId) {
        return Optional.of(taskMap.getOrDefault(taskId,null));
    }

    public boolean delete(Integer taskId) {
        try {
            taskMap.remove(taskId);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    public Map<Integer, Task> getAll() {
        return this.taskMap;
    }
}
