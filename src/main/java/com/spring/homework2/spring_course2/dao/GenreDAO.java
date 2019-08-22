package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */
public interface GenreDAO {
    /**
     * Create long.
     *
     * @param genre the genre
     * @return the long
     */
    long create(Genre genre);

    /**
     * Update boolean.
     *
     * @param genre the genre
     * @return the boolean
     */
    boolean update(Genre genre);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Genre getById(long id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Genre> getAll();

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(long id);
}
