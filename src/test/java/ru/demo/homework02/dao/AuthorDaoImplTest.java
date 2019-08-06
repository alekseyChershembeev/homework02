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


import static org.assertj.core.api.Assertions.assertThat;
@JdbcTest
@RunWith(SpringRunner.class)
@Import(AuthorDaoImpl.class)
public class AuthorDaoImplTest {


    @Autowired
    private AuthorDaoImpl authorDao;

    @Before
    public void setUp() {
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
    }

    @Test
    public void getAuthorById() {
    }

    @Test
    public void addNewAuthor() {
    }

    @Test
    public void deleteAuthor() {
    }

    @Test
    public void deleteAuthorById() {
    }

    @Test
    public void deleteAll() {
    }
}