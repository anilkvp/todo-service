package com.coldstone.todo.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 */
@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @Column(name="action", nullable = false)
    private String action;

    private String title;
/*
    @Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false, nullable = false)
    private Date createDate;

    @Column(name="update_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false, nullable = false)
    private Date updateDate;*/
}
