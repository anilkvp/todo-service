package com.coldstone.todo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoTest {

    private Todo todo;

    @BeforeEach
    void setUp() {
        todo = new Todo();
    }

    @Test
    public void instanceNotNULL(){
        Assertions.assertNotNull(todo," Object instance cannot be null");
    }


}