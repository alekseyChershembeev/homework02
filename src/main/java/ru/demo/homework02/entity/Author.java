package ru.demo.homework02.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Entity;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_name")
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
