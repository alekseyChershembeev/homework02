package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */

public interface GenreDAO {
    long create(Genre genre);

    boolean update(Genre genre);

    Genre getById(long id);

    List<Genre> getAll();

    boolean delete(long id);
}
