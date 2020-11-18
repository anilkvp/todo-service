package com.coldstone.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Collection<Todo> getAll() {
        return todoRepository.getAll();
    }

    public Todo get(Long id) {
        return todoRepository.get(id);
    }

    public Long create(Todo todo) {
        return todoRepository.create(todo);
    }

    public Long update(Todo todo) {
        return todoRepository.update(todo);
    }

    public boolean delete(Long id) {
        return todoRepository.delete(id);
    }
}
