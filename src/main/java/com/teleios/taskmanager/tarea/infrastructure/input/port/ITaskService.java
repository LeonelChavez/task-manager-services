package com.teleios.taskmanager.tarea.infrastructure.input.port;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<TaskEntity> getAllTask();
    Optional<TaskEntity> getTaskById(Long id);
    TaskEntity createTask(TaskEntity tarea);
    TaskEntity updateTask(Long id, TaskEntity tarea);
    void deleteTask(Long id);
}
