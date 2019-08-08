package ru.demo.homework02.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.demo.homework02.entity.Book;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:06.
 */
@Repository
public class BookDaoImpl implements BookDAO {

    private final NamedParameterJdbcOperations namedJdbc;

    @Autowired
    public BookDaoImpl(NamedParameterJdbcOperations namedJdbc) {
        this.namedJdbc = namedJdbc;
    }

    private static final String SQL_GET_ALL_TITLES =
            "SELECT  books.title, authors.author_name, genres.genre_name" +
            "FROM books" +
            "LEFT OUTER JOIN genres  ON books.genre_id = genres.id" +
            "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id" +
            "LEFT OUTER JOIN authors ON books_authors.authors_id = authors.id";
    
    private static final String SQL_GET_ALL_BOOKS = "";
    private static final String SQL_GET_BOOKS_BY_AUTHOR = "";
    private static final String SQL_GET_BOOKS_BY_TITLE = "";
    private static final String SQL_GET_BOOKS_BY_ID = "";
    private static final String SQL_ADD_NEW_BOOK = "";
    private static final String SQL_UPDATE_BOOK_TITLE_BY_ID = "";
    private static final String SQL_DELETE_BOOK_BY_ID = "";
    private static final String SQL_DELETE_ALL = "";

    @Override
    public List<String> getAllTitles() {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(AuthorDAO author) {
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return null;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return null;
    }

    @Override
    public int addNewBook(Book book) {
        return 0;
    }

    @Override
    public int updateBookTitleById(Long id, String newTitle) {
        return 0;
    }

    @Override
    public int deleteBookById(Long id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
