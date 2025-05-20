package com.teleios.taskmanager.tarea.infrastructure.output.port;

import com.teleios.taskmanager.tarea.domain.model.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITareaRepository extends JpaRepository <TareaEntity, Long> {
    // JpaRepository provides basic CRUD operations
    // Additional custom query methods can be defined here if needed
}
