package com.coldstone.todo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/**
 *
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     *
     * @return
     */
    @GetMapping("/todos")
    public ResponseEntity<?> getTodos() {
        return ResponseEntity.ok(todoService.getAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/todo/{id}")
    public ResponseEntity<?> getTodo(@PathVariable("id") String id) {
        Optional<Todo> optionalTodo = todoService.get(Long.valueOf(id));
        if(optionalTodo.isPresent()) {
            return ResponseEntity.ok(optionalTodo.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     *
     * @param todo
     * @return
     */
    @PostMapping("/todo")
    public ResponseEntity<?> create(@RequestBody Todo todo) {

        Todo t = todoService.create(todo);
        if (t == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(t.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(t);
        }
    }

    /**
     *
     * @param todo
     * @return
     */
    @PutMapping("/todo")
    public ResponseEntity<?> update(@RequestBody Todo todo) {
        Todo t = todoService.create(todo);
        if (t == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(todo);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return ResponseEntity.noContent().build();
    }
}
