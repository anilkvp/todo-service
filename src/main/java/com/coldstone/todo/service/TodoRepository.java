package com.coldstone.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Service
public class TodoRepository {

    private final Map<Long, Todo> longTodoMap = new HashMap<>();

    private Random random = new Random();

    public Collection<Todo> getAll() {
        return longTodoMap.values();
    }

    public Todo get(Long id) {
        return longTodoMap.get(id);
    }

    public Long create(Todo todo) {
        Long id = random.nextLong();
        todo.setId(id);
        todo.setScheduledFor(ZonedDateTime.now());
        todo.setCreateDate(ZonedDateTime.now());
        todo.setUpdateDate(ZonedDateTime.now());
        longTodoMap.put(id, todo);
        return id;
    }

    public Long update(Todo todo) {
        todo.setScheduledFor(ZonedDateTime.now());
        todo.setUpdateDate(ZonedDateTime.now());
        Todo out = longTodoMap.putIfAbsent(random.nextLong(), todo);
        return todo.getId();
    }

    public boolean delete(Long id) {
        Todo val = longTodoMap.remove(id);
        if(val != null){
            return true;
        }
        return false;
    }
}
