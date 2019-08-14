package ru.demo.homework02.cli;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.dao.AuthorDaoImpl;
import ru.demo.homework02.dao.BookDaoImpl;
import ru.demo.homework02.dao.GenreDaoImpl;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Genre;
import ru.demo.homework02.entity.Book;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryShellImplTest {

    private static final String TEST_TITLE_1 = "testName";
    private static final String TEST_TITLE_2 = "testName2";
    private static final String TEST_AUTHOR_1 = "testAuthor";
    private static final String TEST_AUTHOR_2 = "testAuthor2";
    private static final String TEST_GENRE_1 = "testGenre";
    private static final String TEST_GENRE_2 = "testGenre2";

    @MockBean
    private Shell shell;

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    private GenreDaoImpl genreDao;

    private String title;
    private Author author;
    private Genre genre;
    private Book book;


    @Before
    public void setUp() throws Exception {
//        genreDao.deleteAll();
//        authorDao.deleteAll();
//        bookDao.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllBooks() {
        author = new Author();
        author.setId(2L);
        author.setName("Л.Толстой");

        genre= new Genre(2L,"роман");
        book = new Book();
        book.setAuthors(author);
        book.setGenre(genre);
        book.setTitle("Теjfgkfl");

    }

    @Test
    public void getAllAuthorsNames() {
        bookDao.addNewBook(book);

        Object ob =
                shell.evaluate(()->"all-names");

        System.out.println(ob.toString());
    }

    @Test
    public void getAllGenres() {
    }

    @Test
    public void getBooksByAuthorsName() {
    }

    @Test
    public void addNewGenre() {
    }

    @Test
    public void addNewBook() {
    }

    @Test
    public void addNewAuthor() {
    }

    @Test
    public void updateBookTitleById() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void deleteAuthorById() {
    }

    @Test
    public void deleteGenre() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void getTableFromList() {
    }


}