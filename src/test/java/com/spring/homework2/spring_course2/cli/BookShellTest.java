package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookShell.class)

public class BookShellTest {

    private static final String TEST_TITLE_1 = "testName";
    private static final String TEST_TITLE_2 = "testName2";
    private static final String TEST_AUTHOR_1 = "testAuthor";
    private static final String TEST_AUTHOR_2 = "testAuthor2";
    private static final String TEST_GENRE_1 = "testGenre";
    private static final String TEST_GENRE_2 = "testGenre2";
    private static final String TEST_TEXT_1 = "testText1";
    private static final String TEST_TEXT_2 = "testText2";

    @Autowired
    private Shell shell;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    public void getAllBooksNames() {
        bookRepository.save(new Book(TEST_TITLE_1, TEST_AUTHOR_1, TEST_GENRE_1, TEST_TEXT_1));
        Object res = shell.evaluate(() -> "all-books");
        System.out.println(res.toString());
    }

    @Test
    public void addNewBook() {
    }

    @Test
    public void updateBookById() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void getAllAuthorsNames() {
    }

    @Test
    public void addNewComment() {
    }

    @Test
    public void getComments() {
    }

    @Test
    public void deleteComment() {
    }
}