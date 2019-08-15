package ru.demo.homework02.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.entity.Genre;


@DataJpaTest
@RunWith(SpringRunner.class)
@Import(GenreDaoImpl.class)
@DirtiesContext
public class GenreDaoImplTest {

    @Autowired
    GenreDaoImpl genreDao;

    private Genre genre;

    @Before
    public void setUp() {
        genre = new Genre();
//        genre.setId(6L);
        genre.setGenreName("фантастика");
        genreDao.addGenreObject(genre);
        genreDao.addGenreObject(new Genre("драма"));

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

        System.out.println(genreDao.getGenreByName("фантастика"));
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

    @Test
    public void addGenreObject() {
        System.out.println(genreDao.addGenreObject(genre));
    }
}