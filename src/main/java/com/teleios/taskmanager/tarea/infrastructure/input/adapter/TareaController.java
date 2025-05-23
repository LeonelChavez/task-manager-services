package com.teleios.taskmanager.tarea.infrastructure.input.adapter;

import com.teleios.taskmanager.tarea.domain.model.TaskEntity;
import com.teleios.taskmanager.tarea.infrastructure.input.port.ITareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/tareas")
@AllArgsConstructor
@CrossOrigin("*")
public class TareaController {

    private final ITareaService tareaService;

    @GetMapping
    public List<TaskEntity> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTareaById(@PathVariable("id") Long id) {
        return tareaService.getTareaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<TaskEntity> createTarea(@RequestBody TaskEntity tarea) {
        TaskEntity createdTarea = tareaService.createTarea(tarea);
        return ResponseEntity.status(201).body(createdTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTarea(@PathVariable("id") Long id, @RequestBody TaskEntity tarea) {
        if (!tareaService.getTareaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tareaService.updateTarea(id, tarea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable("id") Long id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }
}
