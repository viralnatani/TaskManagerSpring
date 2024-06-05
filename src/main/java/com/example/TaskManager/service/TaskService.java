package com.example.TaskManager.service;

import com.example.TaskManager.entities.TaskEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskId);
        taskEntity.setTitle(title);
        taskEntity.setDescription(description);
        //taskEntity.setDeadline(new Date(deadline)); //TODO: validate date format;
        taskEntity.setCompleted(false);
        tasks.add(taskEntity);
        taskId++;
        return taskEntity;
    }

    public List<TaskEntity> getTasks(){
        return tasks;
    }

    public TaskEntity getTaskById(int id){
        return tasks.stream().findAny().filter(taskEntity -> taskEntity.getId() == id).orElse(null);
    }

}
