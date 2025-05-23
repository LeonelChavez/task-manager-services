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

    private final ITaskRepository taskRepository;

    @Override
    public List<TaskEntity> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity updateTask(Long id, TaskEntity task) {
        if( !taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with id " + id + " does not exist");
        }
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
