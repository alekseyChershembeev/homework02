package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */

public interface GenreService {

    long create(Genre genre);

    boolean update(Genre genre);

    Genre getById(long id);

    List<Genre> getAll();

    boolean delete(long id);
}
