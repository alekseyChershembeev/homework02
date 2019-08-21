package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.CommentDAO;
import com.spring.homework2.spring_course2.dao.GenreDAO;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Import(GenreServiceImpl.class)
public class GenreServiceImplTest {


    @Autowired
    private GenreService genreService;

    @MockBean
    GenreDAO genreDAO;


    private Genre genre;

    @Before
    void setUp() throws Exception {
        genre = new Genre();
        genre.setGenreName("Fantastic");
    }

    @Test
    void create() {
        genreService.create(genre);
    }

    @Test
    void update() {
        genreService.update(genre);
    }

    @Test
    void getById() {
        genreService.getById(1L);
    }

    @Test
    void getAll() {
        genreService.getAll();
    }

    @Test
    void delete() {
        genreService.delete(1L);
    }
}