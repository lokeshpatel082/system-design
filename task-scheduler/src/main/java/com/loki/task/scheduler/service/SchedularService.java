package com.loki.task.scheduler.service;

import com.loki.task.scheduler.exception.ConflictingTaskException;
import com.loki.task.scheduler.exception.TaskNotFoundException;
import com.loki.task.scheduler.model.Task;

import java.time.LocalDateTime;
import java.util.Map;

public interface SchedularService {
    public Task createTask(Task task) throws ConflictingTaskException;

    public boolean deleteTask(Integer id) throws TaskNotFoundException;

    public Task getTaskById(Integer id) throws TaskNotFoundException;

    public Map<Integer,Task> getAllTasks();

    public Task updateTask(Integer id, LocalDateTime startTime, LocalDateTime endTime) throws TaskNotFoundException, ConflictingTaskException;
}
