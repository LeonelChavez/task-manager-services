package com.teleios.taskmanager.tarea.application;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;
import com.teleios.taskmanager.tarea.infrastructure.input.port.ITaskService;
import com.teleios.taskmanager.tarea.infrastructure.output.port.ITaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskImpl implements ITaskService {

    private final ITaskRepository repository;

    @Override
    public List<TaskEntity> getAllTask() {
        return repository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTaskById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TaskEntity createTask(TaskEntity tarea) {
        return repository.save(tarea);
    }

    @Override
    public TaskEntity updateTask(Long id, TaskEntity tarea) {
        if( !repository.existsById(id)) {
            throw new IllegalArgumentException("Tarea with id " + id + " does not exist");
        }
        return repository.save(tarea);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
