package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GenreDaoImplTest {

    @Autowired
    private GenreRepository dao;

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
        dao.save(genre);
        assertThat(dao.save(genre).getGenreId())
                .isEqualTo(1L);


    }

    @Test
    public void update() {
        long id;
        Genre genre3 = dao.save(genre);
        id = genre3.getGenreId();
        genre3.setGenreName("Drama");
        dao.save(genre3);

        assertThat(dao.findById(genre3.getGenreId()).get())
                .hasFieldOrPropertyWithValue("genreId",id)
                .hasFieldOrPropertyWithValue("genreName","Drama");

    }

    @Test
    public void getById() {
        Genre genre2 = dao.save(genre);
        Genre genre = dao.findById(genre2.getGenreId()).get();
        assertThat(genre)
                .hasFieldOrPropertyWithValue("genreId", genre2.getGenreId())
                .hasFieldOrPropertyWithValue("genreName", "Fantastic");
    }

    @Test
    public void getAll() {
        dao.save(genre);
        Genre genre2 = new Genre();
        genre2.setGenreName("Horror");
        dao.save(genre2);

        List<Genre> genres = (List<Genre>) dao.findAll();
        assertThat(genres)
                .isNotNull();
        assertEquals(genres.size(),2);


    }

    @Test
    public void delete() {

        Genre genre2 = dao.save(genre);;
        Genre genre3 = dao.save(new Genre("testGenre"));;


//        assertThat(dao.findById(genre2.getGenreId()).get())
//                .hasFieldOrPropertyWithValue("genreId",genre2.getGenreId())
//                .hasFieldOrPropertyWithValue("genreName","Fantastic");

        dao.deleteGenreByGenreId(genre2.getGenreId());
        List<Genre> list = (List<Genre>) dao.findAll();

        assertEquals(list.size(),1);




    }
}