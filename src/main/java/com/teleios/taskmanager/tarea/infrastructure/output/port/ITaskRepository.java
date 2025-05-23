package com.teleios.taskmanager.tarea.infrastructure.output.port;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository <TaskEntity, Long> {
}
