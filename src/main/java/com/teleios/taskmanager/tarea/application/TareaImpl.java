package com.teleios.taskmanager.tarea.application;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;
import com.teleios.taskmanager.tarea.infrastructure.input.port.ITareaService;
import com.teleios.taskmanager.tarea.infrastructure.output.port.ITareaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TareaImpl implements ITareaService {

    private final ITareaRepository repository;

    @Override
    public List<TaskEntity> getAllTareas() {
        return repository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTareaById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TaskEntity createTarea(TaskEntity tarea) {
        return repository.save(tarea);
    }

    @Override
    public TaskEntity updateTarea(Long id, TaskEntity tarea) {
        if( !repository.existsById(id)) {
            throw new IllegalArgumentException("Tarea with id " + id + " does not exist");
        }
        return repository.save(tarea);
    }

    @Override
    public void deleteTarea(Long id) {
        repository.deleteById(id);
    }
}
