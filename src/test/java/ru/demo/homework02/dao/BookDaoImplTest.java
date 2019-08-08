package ru.demo.homework02.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.entity.Author;

import static org.junit.Assert.*;
@JdbcTest
@RunWith(SpringRunner.class)
@Import(BookDaoImpl.class)
public class BookDaoImplTest {

    @Autowired
    BookDaoImpl bookDAO;

    Author author;

    @Before
    public void setUp() {
        author = new Author();
        author.setId(2L);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllTitles() {
        System.out.println(bookDAO.getAllTitles());
    }

    @Test
    public void getAllBooks() {
        System.out.println(bookDAO.getAllBooks());
    }

    @Test
    public void getBooksByAuthor() {
        System.out.println(bookDAO.getBooksByAuthor(author));

    }

    @Test
    public void getBooksByTitle() {

        String s = "Восточный экспресс";
        System.out.println(bookDAO.getBooksByTitle(s));

    }

    @Test
    public void getBookById() {
    }

    @Test
    public void addNewBook() {
    }

    @Test
    public void updateBookTitleById() {
    }

    @Test
    public void deleteBookById() {
    }
}