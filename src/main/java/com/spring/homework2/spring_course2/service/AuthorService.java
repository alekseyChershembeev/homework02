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

    Long save(Author author);
    Optional<Author> getById(Long id);
    List<Author> findAll();
    boolean deleteAuthorById(Long id);
}
