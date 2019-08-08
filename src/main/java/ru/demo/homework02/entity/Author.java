package ru.demo.homework02.entity;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data

public class Author {

    private Long id;
    private List<Book> books;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(Long id, List<Book> books, String name) {
        this.id = id;
        this.books = books;
        this.name = name;
    }

    public Author(List<Book> books, String name) {
        this.books = books;
        this.name = name;
    }
}
