package com.coldstone.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 */
@Service
public class TodoServiceImpl implements TodoService {

    /**
     *
     */
    @Autowired
    private TodoRepository todoRepository;

    /**
     *
     * @return
     */
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Todo> get(Long id) {
        return todoRepository.findById(id);
    }

    /**
     *
     * @param todo
     * @return
     */
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     *
     * @param todo
     * @return
     */
    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        todoRepository.deleteById(id);
        return true;
    }
}
