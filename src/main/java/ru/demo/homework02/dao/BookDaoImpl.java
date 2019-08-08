package ru.demo.homework02.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.demo.homework02.entity.Author;
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
            "SELECT title FROM books";

    private static final String SQL_GET_ALL_BOOKS =
            "SELECT books.id, books.title, genres.id , genres.genre_name, authors.id , authors.author_name "
                    + "FROM books "
                    + "LEFT OUTER JOIN genres  ON books.genre_id = genres.id "
                    + "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id "
                    + "LEFT OUTER JOIN authors  ON books_authors.authors_id = authors.id";
    private static final String SQL_GET_BOOKS_BY_AUTHOR =
            "SELECT books.id, books.title, genres.id , genres.genre_name, authors.id , authors.author_name "
                    + "FROM books "
                    + "LEFT OUTER JOIN genres  ON books.genre_id = genres.id "
                    + "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id "
                    + "LEFT OUTER JOIN authors ON books_authors.authors_id = authors.id "
                    + "WHERE books.title=:title";
    private static final String SQL_GET_BOOKS_BY_TITLE = "";
    private static final String SQL_GET_BOOKS_BY_ID = "";
    private static final String SQL_ADD_NEW_BOOK = "";
    private static final String SQL_UPDATE_BOOK_TITLE_BY_ID = "";
    private static final String SQL_DELETE_BOOK_BY_ID = "";
    private static final String SQL_DELETE_ALL = "";

    @Override
    public List<String> getAllTitles() {
        return namedJdbc.getJdbcOperations()
                .queryForList(SQL_GET_ALL_TITLES, String.class);
    }


    @Override
    public List<Book> getAllBooks() {
        return namedJdbc.query(SQL_GET_ALL_BOOKS,
                (rs, rw) -> new Book(
                        rs.getLong("id"),
                        rs.getString("author_name"),
                        rs.getString("title"),
                        rs.getString("genre_name")));
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {

        return namedJdbc.query(SQL_GET_BOOKS_BY_AUTHOR,
                new MapSqlParameterSource("id", author.getId()),
                (rs, rw) -> (new Book(
                        rs.getLong("id"),
                        rs.getString("author_name"),
                        rs.getString("title"),
                        rs.getString("genre_name"))));
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return namedJdbc.query(SQL_GET_BOOKS_BY_AUTHOR,
                new MapSqlParameterSource("title", title),
                (rs, rw) -> (new Book(
                        rs.getLong("id"),
                        rs.getString("author_name"),
                        rs.getString("title"),
                        rs.getString("genre_name"))));
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
