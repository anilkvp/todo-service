package com.coldstone.todo.service;

import java.util.Collection;

public interface TodoService {

    Collection<Todo> getAll();
    Todo get(Long id);
    Long create(Todo todo);
    Long update(Todo todo);
    boolean delete(Long id);
}
