package com.coldstone.todo.service;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Todo {

    private Long id;

    private String type;

    private String action;

    private String title;

    private ZonedDateTime scheduledFor;

    private ZonedDateTime createDate;

    private ZonedDateTime updateDate;
}
