package com.loki.task.scheduler.service.impl;

import com.loki.task.scheduler.exception.ConflictingTaskException;
import com.loki.task.scheduler.exception.TaskAlreadyExistsException;
import com.loki.task.scheduler.exception.TaskNotFoundException;
import com.loki.task.scheduler.model.Task;
import com.loki.task.scheduler.repository.TaskRepository;
import com.loki.task.scheduler.service.SchedularService;
import com.loki.task.scheduler.utils.TaskSchedulerUtil;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class SchedulerServiceImpl implements SchedularService {
    private final TaskRepository taskRepository;

    public SchedulerServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) throws ConflictingTaskException {
        Map<Integer, Task> taskMap = this.taskRepository.getAll();
        if (TaskSchedulerUtil.isAnyConflictingTask(task, taskMap)) {
            throw new ConflictingTaskException("Conflicting time for two or more tasks !!");
        }
        return this.taskRepository.create(task);
    }

    @Override
    public boolean deleteTask(Integer taskId) throws TaskNotFoundException {
        return this.taskRepository.delete(taskId);
    }

    @Override
    public Task getTaskById(Integer id) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.get(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new TaskNotFoundException();
        }
    }

    @Override
    public Map<Integer, Task> getAllTasks() {
        return this.taskRepository.getAll();
    }

    @Override
    public Task updateTask(Integer id, LocalDateTime newStartTime, LocalDateTime newEndTime) throws TaskNotFoundException, ConflictingTaskException {
        Optional<Task> existingTask = taskRepository.get(id);
        if (existingTask.isEmpty()) {
            throw new TaskNotFoundException();
        }
        Map<Integer, Task> taskMap = this.taskRepository.getAll();
        Task task = existingTask.get();
        LocalDateTime prevStartTime = task.getStartTime();
        LocalDateTime prevEndTime = task.getEndTime();
        task.setStartTime(newStartTime);
        task.setEndTime(newEndTime);

        if (TaskSchedulerUtil.isAnyConflictingTask(task, taskMap)) {
            task.setStartTime(prevStartTime);
            task.setEndTime(prevEndTime);
            throw new ConflictingTaskException("Conflicting time , can not update task !!");
        }
        return task;
    }
}
