package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.*;

@RunWith(SpringRunner.class)

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class BookDaoImplTest {


    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BookRepository bookRepository;

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

        assertThat(bookRepository.save(expected))
                .hasFieldOrPropertyWithValue("bookName","book");
    }

    @Test
    public void update() {
        bookRepository.save(new Book("book", author, genre));
        book.setBookName("book2");
        book.setBookGenre(genre);
        book.setBookAuthor(author);
        bookRepository.save(book);


    }

    @Test
    public void getById() {
        Book newBook = bookRepository.save(new Book("book", author, genre));
        assertThat(newBook)
                .hasFieldOrPropertyWithValue("bookId", newBook.getBookId())
                .hasFieldOrPropertyWithValue("bookName", "book")
                .hasFieldOrPropertyWithValue("bookAuthor.authorId", newBook.getBookAuthor().getAuthorId())
                .hasFieldOrPropertyWithValue("bookAuthor.authorName", "Author")
                .hasFieldOrPropertyWithValue("bookAuthor.authorLastName", "AuthorLastName")
                .hasFieldOrPropertyWithValue("bookGenre.genreId", newBook.getBookGenre().getGenreId())
                .hasFieldOrPropertyWithValue("bookGenre.genreName", "Genre");
    }

    @Test
    public void getAll() {
        bookRepository.save(new Book("book", author, genre));
        bookRepository.save(new Book("book2", author, genre));

        List<Book> all = (List<Book>) bookRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }

    @Test
    public void delete() {
        Book book2 = new Book("book", author, genre);
        bookRepository.save(book2);
        bookRepository.delete(book2);



    }
}