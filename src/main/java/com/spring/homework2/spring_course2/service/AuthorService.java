package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */
public interface AuthorService {

    /**
     * Create long.
     *
     * @param author the author
     * @return the long
     */
    long create(Author author);

    /**
     * Update boolean.
     *
     * @param author the author
     * @return the boolean
     */
    boolean update(Author author);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Author getById(long id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Author> getAll();

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(long id);
}
