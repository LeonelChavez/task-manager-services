package com.teleios.taskmanager.tarea.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskEntity implements Serializable, Comparable<TaskEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private Boolean completado;

    @Override
    public int compareTo(TaskEntity o) {
        if (this.id == null && o.id == null) return 0;
        if (this.id == null) return -1;
        if (o.id == null) return 1;
        return this.id.compareTo(o.id);
    }
}
