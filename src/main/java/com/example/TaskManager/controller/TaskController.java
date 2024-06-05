package com.example.TaskManager.controller;

import com.example.TaskManager.dto.CreateTaskDto;
import com.example.TaskManager.entities.TaskEntity;
import com.example.TaskManager.service.TaskService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
        TaskEntity taskEntity = taskService.getTaskById(id);
        if(taskEntity == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(taskEntity);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto body){
        TaskEntity task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
        
    }

}
