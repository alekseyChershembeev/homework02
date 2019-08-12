package ru.demo.homework02.entity;

import lombok.Data;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data
public class Book {

    private Long id;
    private Author authors;
    private String title;
    private Genre genre;

    public Book() {
    }

    public Book(Long id, Author authors, String title, Genre genre) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }

    public Book(Author authors, String title, Genre genre) {
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }
}
