package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@Import(BookDaoImpl.class)
@Transactional
public class BookDaoImplTest {


    @Autowired
    private BookDAO bookDAO;

    private Book book;
    private Author author;
    private Genre genre;


    @Before
    public void setUp() {
        book = new Book();
        author = new Author();
        author.setAuthorName("Author");
        author.setAuthorLastName("AuthorLastName");

        genre = new Genre();
        genre.setGenreName("Genre");

        book.setBookName("Book");
        book.setBookAuthor(author);
        book.setBookGenre(genre);


    }


    @Test
    public void create() {
        Book expected = new Book("book", author, genre);
        long id = bookDAO.create(expected);
        assertEquals(id, 1L);
    }

    @Test
    public void update() {
        bookDAO.create(new Book("book", author, genre));
        book.setBookName("book2");
        book.setBookGenre(genre);
        book.setBookAuthor(author);
        bookDAO.update(book);


    }

    @Test
    public void getById() {
        long id = bookDAO.create(new Book("book", author, genre));
        Book newBook = bookDAO.getById(id);
        assertThat(newBook)
                .hasFieldOrPropertyWithValue("bookId", 1L)
                .hasFieldOrPropertyWithValue("bookName", "book")
                .hasFieldOrPropertyWithValue("bookAuthor.authorId", 1L)
                .hasFieldOrPropertyWithValue("bookAuthor.authorName", "Author")
                .hasFieldOrPropertyWithValue("bookAuthor.authorLastName", "AuthorLastName")
                .hasFieldOrPropertyWithValue("bookGenre.genreId", 1L)
                .hasFieldOrPropertyWithValue("bookGenre.genreName", "Genre");
    }

    @Test
    public void getAll() {
        bookDAO.create(new Book("book", author, genre));
        bookDAO.create(new Book("book2", author, genre));

        assertThat(bookDAO.getAll().size()).isEqualTo(2);

    }

    @Test
    public void delete() {
        bookDAO.create(new Book("book", author, genre));
        bookDAO.delete(1L);



    }
}