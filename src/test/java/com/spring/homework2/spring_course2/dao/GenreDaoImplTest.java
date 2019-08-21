package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@Import(GenreDaoImpl.class)
@Transactional
public class GenreDaoImplTest {

    @Autowired
    private GenreDAO dao;

    private Genre genre;

    @Before
    public void setUp() {
        genre = new Genre();
        genre.setGenreName("Fantastic");

    }

    @After
    public void tearDown() {

    }

    @Test
    public void create() {
        dao.create(genre);
        assertThat(dao.create(genre))
                .isEqualTo(1L);


    }

    @Test
    public void update() {
        dao.create(genre);
        genre.setGenreName("Drama");
        dao.update(genre);

        assertThat(dao.getById(1L))
                .hasFieldOrPropertyWithValue("genreId",1L)
                .hasFieldOrPropertyWithValue("genreName","Drama");

    }

    @Test
    public void getById() {
        dao.create(genre);
        Genre genre = dao.getById(1L);
        assertThat(genre)
                .hasFieldOrPropertyWithValue("genreId", 1L)
                .hasFieldOrPropertyWithValue("genreName", "Fantastic");
    }

    @Test
    public void getAll() {
        dao.create(genre);
        Genre genre2 = new Genre();
        genre2.setGenreName("Horror");
        dao.create(genre2);

        List<Genre> genres = dao.getAll();
        assertThat(genres)
                .isNotNull();
        assertEquals(genres.size(),2);


    }

    @Test
    public void delete() {
        dao.create(genre);
        Genre genre2 = new Genre();
        genre2.setGenreName("Thriller");
        dao.create(genre2);

        assertThat(dao.getById(1L))
                .hasFieldOrPropertyWithValue("genreId",1L)
                .hasFieldOrPropertyWithValue("genreName","Fantastic");

        dao.delete(1L);

        assertEquals(dao.getAll().size(),1);




    }
}