package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:43.
 */

public interface BookDAO {
    long create(Book book);

    void update(Book book);

    Book getById(long id);

    List<Book> getAll();

    void delete(long id);
}
