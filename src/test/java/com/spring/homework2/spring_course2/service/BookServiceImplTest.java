package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.BookDAO;
import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Import(BookServiceImpl.class)
public class BookServiceImplTest {



    @Autowired
    BookService bookService;

    @MockBean
    private BookDAO bookDAO;

    private Book book;
    private Author author;
    private Genre genre;

    @Before
    void setUp() throws Exception {
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
    void create() {
        bookService.create(book);
    }

    @Test
    void update() {
        bookService.create(book);
        Book newBook = new Book("book2", author, genre);
        bookService.update(newBook);
    }

    @Test
    void getById() {
        bookService.getById(1L);
    }

    @Test
    void getAll() {
        bookService.getAll();
    }

    @Test
    void delete() {
        bookService.delete(1L);
    }

//    @Test
//     void getBooksByAuthorsName() {
//        bookService.getBooksByAuthorsName(author);
//    }
}