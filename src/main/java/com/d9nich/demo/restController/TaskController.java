package com.d9nich.demo.restController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {
    }

    @PostMapping(path = "/tasks")
    public void addTask(@RequestBody Task task){
        tasks.add(task);
    }

}
