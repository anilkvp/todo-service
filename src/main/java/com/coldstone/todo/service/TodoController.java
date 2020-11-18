package com.coldstone.todo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getTodos(){
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> getTodo(@PathVariable("id") String id){
        return ResponseEntity.ok(todoService.get(Long.valueOf(id)));
    }

    @PostMapping("/todo")
    public ResponseEntity<?> create(@RequestBody Todo todo){
        URI uri = null;
        Long id = todoService.create(todo);
        try {
            uri = new URI(id.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ResponseEntity.created(uri).body(todo);
    }

    @PutMapping("/todo")
    public ResponseEntity<?> update(@RequestBody Todo todo){
        URI uri = null;
        Long id = todoService.update(todo);
        try {
            uri = new URI(id.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return ResponseEntity.ok().build();
    }
}
