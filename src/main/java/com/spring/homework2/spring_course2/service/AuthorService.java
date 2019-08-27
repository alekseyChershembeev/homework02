package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import java.util.Optional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */
public interface AuthorService {

    /**
     * Save long.
     *
     * @param author the author
     * @return the long
     */
    Long save(Author author);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Optional<Author> getById(Long id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Author> findAll();

    /**
     * Delete author by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteAuthorById(Long id);
}
