package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */
public interface BookService {

    /**
     * Create long.
     *
     * @param book the book
     * @return the long
     */
    long create(Book book);

    /**
     * Update boolean.
     *
     * @param book the book
     * @return the boolean
     */
    boolean update(Book book);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Book getById(long id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Book> getAll();

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(long id);

//    List<Book> getBooksByAuthorsName(Author author);
}
