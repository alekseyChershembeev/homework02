package ru.demo.homework02.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.entity.Author;


import static org.assertj.core.api.Assertions.assertThat;
@JdbcTest
@RunWith(SpringRunner.class)
@Import(AuthorDaoImpl.class)
public class AuthorDaoImplTest {


    @Autowired
    private AuthorDaoImpl authorDao;

    private String authorName;
    private Author author;
    @Before
    public void setUp() {
        authorName = "Л.Толстой";
        author = new Author();
        author.setName(authorName);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllAuthorsNames() {
        List<String>authors = authorDao.getAllAuthorsNames();
//        assertThat(authors).isEmpty();
        System.out.println(authors);

        assertThat(authors)
                .hasSize(4)
                .contains("А.Кристи")
                .contains("Л.Толстой")
                .contains("Ф.Достоевский")
                .contains("В.Пелевин");

    }

    @Test
    public void getAuthorByName() {

        System.out.println(authorDao.getAuthorByName(authorName).isPresent());
    }

    @Test
    public void getAuthorById() {
        System.out.println(authorDao.getAuthorById(2L).isPresent());
    }

    @Test
    public void addNewAuthor() {

       assertThat(authorDao.addNewAuthor(new Author("Т. Драйзер")))
       .isEqualTo(1);

    }

    @Test
    public void deleteAuthor() {
        assertThat(authorDao.deleteAll())
                .isEqualTo(6);
    }

    @Test
    public void deleteAuthorById() {
        assertThat(authorDao.deleteAuthorById(2L))
                .isEqualTo(1);
    }

    @Test
    public void deleteAll() {
        assertThat(authorDao.deleteAll()).isEqualTo(6);
    }

    @Test
    public void addNewAuthorObject() {

        System.out.println(authorDao.addAuthorObject(author));
        System.out.println(authorDao.addAuthorObject(author));
    }
}