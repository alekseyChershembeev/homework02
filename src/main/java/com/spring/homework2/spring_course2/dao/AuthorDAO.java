package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:44.
 */

public interface AuthorDAO {

    long create(Author author);

    boolean update(Author author);

    Author getById(long id);

    List<Author> getAll();

    boolean delete(long id);
}
