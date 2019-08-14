package ru.demo.homework02.entity;

import java.util.Objects;
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

    /**
     * Instantiates a new Book.
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param id      the id
     * @param authors the authors
     * @param title   the title
     * @param genre   the genre
     */
    public Book(Long id, Author authors, String title, Genre genre) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }

    /**
     * Instantiates a new Book.
     *
     * @param authors the authors
     * @param title   the title
     * @param genre   the genre
     */
    public Book(Author authors, String title, Genre genre) {
        this.authors = authors;
        this.title = title;
        this.genre = genre;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authors, title, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
