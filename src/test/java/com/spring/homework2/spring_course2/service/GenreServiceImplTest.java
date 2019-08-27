package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.repository.GenreRepository;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Import(GenreServiceImpl.class)
public class GenreServiceImplTest {


    @Autowired
    private GenreService genreService;

    @MockBean
    GenreRepository genreRepository;


    private Genre genre;

    @Before
    public void setUp() {
        reset(genreRepository);
        genre = new Genre();
        genre.setGenreName("Fantastic");
    }

    @Test
    public void create() {
        genreService.create(genre);

    }

    @Test
    public void update() {
        genreService.create(genre);
    }

    @Test
    public void getById() {
        genreService.getById(1L);
    }

    @Test
    public void getAll() {
        genreService.getAll();
    }

    @Test
    public void delete() {
        genreService.delete(1L);
    }
}