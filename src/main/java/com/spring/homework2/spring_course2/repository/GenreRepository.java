package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {


    /**
     * Delete genre by genre id int.
     *
     * @param id the id
     * @return the int
     */
    int deleteGenreByGenreId(Long id);
}
