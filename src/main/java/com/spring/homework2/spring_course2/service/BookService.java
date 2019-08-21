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

    long create(Book book);

    void update(Book book);

    Book getById(long id);

    List<Book> getAll();

    void delete(long id);

//    List<Book> getBooksByAuthorsName(Author author);
}
