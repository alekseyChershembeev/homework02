package ru.demo.homework02.entity;

import java.util.*;
import lombok.Data;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data
public class Book {

    private Long id;
    private String authors;
    private String title;
    private String genre;

    public Book(Long id, String authors, String title, String genre) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }

    public Book(String authors, String title, String genre) {
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }
}
