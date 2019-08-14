package ru.demo.homework02.entity;

import lombok.Data;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data

public class Author {

    private Long id;
    private String name;

    /**
     * Instantiates a new Author.
     */
    public Author() {
    }

    /**
     * Instantiates a new Author.
     *
     * @param name the name
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Author.
     *
     * @param id   the id
     * @param name the name
     */
    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
