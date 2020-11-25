package com.coldstone.todo.service;

import java.util.Optional;

public interface TodoService {

    Iterable<Todo> getAll();
    Optional<Todo> get(Long id);
    Long create(Todo todo);
    Long update(Todo todo);
    boolean delete(Long id);
}
