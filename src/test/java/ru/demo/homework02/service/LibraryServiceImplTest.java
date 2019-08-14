package ru.demo.homework02.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import ru.demo.homework02.dao.AuthorDaoImpl;
import ru.demo.homework02.dao.BookDaoImpl;
import ru.demo.homework02.dao.GenreDaoImpl;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LibraryServiceImplTest {

    private static final String TEST_AUTHOR = "AUTHOR_TEST";
    private static final String TEST_GENRE = "GENRE_TEST";
    private static final String TEST_TiTLE = "TITLE_TEST";
    private static final String TEST_TiTLE2 = "TITLE_TEST2";

    private Genre genre;
    private Author author;
    private Book book;

    @Mock
    private BookDaoImpl bookDao;
    @Mock
    private AuthorDaoImpl authorDao;
    @Mock
    private GenreDaoImpl genreDao;

    @InjectMocks
    LibraryServiceImpl libraryService;

    //перезапускаем dao
    @Before
    public void setUp() {
        reset(bookDao);
        reset(authorDao);
        reset(genreDao);

        genre = new Genre();
        genre.setId(2L);
        genre.setGenreName(TEST_GENRE);

        author = new Author();
        author.setId(1L);
        author.setName(TEST_AUTHOR);

        book = new Book();
        book.setId(3L);
        book.setTitle(TEST_TiTLE);
        book.setGenre(genre);
        book.setAuthors(author);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllBooks() {

        System.out.println(libraryService.getAllBooks());
        verify(bookDao).getAllBooks();

    }

    @Test
    public void getAllAuthorsNames() {
        libraryService.getAllAuthorsNames();
        verify(authorDao).getAllAuthorsNames();
    }

    @Test
    public void getAllGenres() {

        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        when(genreDao.getAllGenres()).thenReturn(genres);
        List<String> list = libraryService.getAllGenres();
        verify(genreDao).getAllGenres();
        assertThat(list)
                .isNotEmpty()
                .hasSize(1)
                .contains(TEST_GENRE);
    }

    @Test
    public void getBooksByAuthorsName() {

        libraryService.getBooksByAuthorsName(TEST_AUTHOR);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(null);
        books.add(new Book());
        ;
    }

    @Test
    public void addNewGenre() {
        libraryService.addNewGenre(genre);
    }

    @Test
    public void addNewBook() {
        libraryService.addNewBook(book);
    }

    @Test
    public void addNewAuthor() {
        libraryService.addNewAuthor(author);
    }

    @Test
    public void updateBookTitleById() {
        libraryService.updateBookTitleById(3L, TEST_TiTLE2);
    }
}