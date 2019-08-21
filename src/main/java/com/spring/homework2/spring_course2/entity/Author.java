package com.spring.homework2.spring_course2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:43.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="authors")
public class Author {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "authorId")
    private long authorId;
    @Column(name = "authorName")
    private String authorName;
    @Column(name = "authorLastName")
    private String authorLastName;

    public Author(String authorName, String authorLastName) {
        this.authorName = authorName;
        this.authorLastName = authorLastName;
    }
}
