package com.teleios.taskmanager.tarea.infrastructure.input.port;

import com.teleios.taskmanager.tarea.domain.model.TareaEntity;

import java.util.List;
import java.util.Optional;

public interface ITareaService {
    List<TareaEntity> getAllTareas();
    Optional<TareaEntity> getTareaById(Long id);
    TareaEntity createTarea(TareaEntity tarea);
    TareaEntity updateTarea(Long id, TareaEntity tarea);
    void deleteTarea(Long id);
}
