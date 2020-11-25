package com.coldstone.todo.service;

import java.util.Optional;

/**
 *
 */
public interface TodoService {

    /**
     *
     * @return
     */
    Iterable<Todo> getAll();

    /**
     *
     * @param id
     * @return
     */
    Optional<Todo> get(Long id);

    /**
     *
     * @param todo
     * @return
     */
    Todo create(Todo todo);

    /**
     *
     * @param todo
     * @return
     */
    Todo update(Todo todo);

    /**
     *
     * @param id
     * @return
     */
    boolean delete(Long id);
}
