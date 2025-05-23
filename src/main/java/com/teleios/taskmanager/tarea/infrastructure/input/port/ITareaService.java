package com.teleios.taskmanager.tarea.infrastructure.input.port;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITareaService {
    List<TaskEntity> getAllTareas();
    Optional<TaskEntity> getTareaById(Long id);
    TaskEntity createTarea(TaskEntity tarea);
    TaskEntity updateTarea(Long id, TaskEntity tarea);
    void deleteTarea(Long id);
}
