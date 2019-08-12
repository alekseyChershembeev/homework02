package ru.demo.homework02.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.entity.Genre;


@JdbcTest
@RunWith(SpringRunner.class)
@Import(GenreDaoImpl.class)
public class GenreDaoImplTest {

    @Autowired
    GenreDaoImpl genreDao;

    private Genre genre;

    @Before
    public void setUp() {
        genre = new Genre();
        genre.setId(6L);
        genre.setGenreName("фантастика");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllGenres() {
        System.out.println(genreDao.getAllGenres());
    }

    @Test
    public void getGenreByName() {
        System.out.println(genreDao.getGenreByName("драма"));
    }

    @Test
    public void addGenre() {
        System.out.println(genreDao.addGenre(genre));
    }

    @Test
    public void deleteGenre() {
        System.out.println(genreDao.deleteGenre(genre));
    }

    @Test
    public void deleteAll() {
        System.out.println(genreDao.deleteAll());
    }
}