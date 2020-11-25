package com.coldstone.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> get(Long id) {
        return todoRepository.findById(id);
    }

    public Long create(Todo todo) {
        Todo t = todoRepository.save(todo);
        return t.getId();
    }

    public Long update(Todo todo) {
        Todo t = todoRepository.save(todo);
        return t.getId();
    }

    public boolean delete(Long id) {
        todoRepository.deleteById(id);
        return true;
    }
}
