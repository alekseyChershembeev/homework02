package ru.demo.homework02.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:06.
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDAO {


    @PersistenceContext
    private EntityManager em;

//    private final NamedParameterJdbcOperations namedJdbc;

//    /**
//     * Instantiates a new Book dao.
//     *
//     * @param namedJdbc the named jdbc
//     */
//    @Autowired
//    public BookDaoImpl(NamedParameterJdbcOperations namedJdbc) {
//        this.namedJdbc = namedJdbc;
//    }

//    private static final String SQL_GET_ALL_TITLES =
//            "SELECT title FROM books";
//    private static final String SQL_GET_ALL_BOOKS =
//            "SELECT books.id, books.title, genres.id , genres.genre_name, authors.id , authors.author_name "
//                    + "FROM books "
//                    + "LEFT OUTER JOIN genres  ON books.genre_id = genres.id "
//                    + "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id "
//                    + "LEFT OUTER JOIN authors  ON books_authors.authors_id = authors.id";
//    private static final String SQL_GET_BOOKS_BY_AUTHOR =
//            "SELECT books.id, books.title, genres.id , genres.genre_name, authors.id , authors.author_name "
//                    + "FROM books "
//                    + "LEFT OUTER JOIN genres  ON books.genre_id = genres.id "
//                    + "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id "
//                    + "LEFT OUTER JOIN authors ON books_authors.authors_id = authors.id "
//                    + "WHERE books.title=:title";
//    private static final String SQL_GET_BOOKS_BY_ID =
//            "SELECT books.id, books.title, genres.id , genres.genre_name, authors.id , authors.author_name "
//                    + "FROM books "
//                    + "LEFT OUTER JOIN genres  ON books.genre_id = genres.id "
//                    + "LEFT OUTER JOIN books_authors ON books.id = books_authors.books_id "
//                    + "LEFT OUTER JOIN authors ON books_authors.authors_id = authors.id "
//                    + "WHERE books.id=:id";
//    private static final String SQL_INSERT_NEW_BOOK =
//            "INSERT INTO books (title, genre_id) VALUES (:title, :genre_id)";
//    private static final String SQL_INSERT_INTO_BOOK_AUTHORS =
//            "INSERT INTO books_authors (authors_id, books_id) VALUES (:a_id, :b_id)";
//    private static final String SQL_UPDATE_BOOK_TITLE_BY_ID =
//            "UPDATE books SET title =:title WHERE id =:id";
//    private static final String SQL_DELETE_BOOK_BY_ID =
//            "DELETE FROM books WHERE id = :id";
//    private static final String SQL_DELETE_BOOKS_AUTHORS =
//            "DELETE FROM books_authors";
//    private static final String SQL_DELETE_BOOKS =
//            "DELETE FROM books";


    @Override
    public List<String> getAllTitles() {
        try {
//            return namedJdbc.getJdbcOperations()
//                    .queryForList(SQL_GET_ALL_TITLES, String.class);
            TypedQuery<String> query = em.createQuery("SELECT b.title FROM Book b", String.class);
            return query.getResultList();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        try {
//            return namedJdbc.query(SQL_GET_ALL_BOOKS,
//                    (rs, rw) -> getBook(rs));


            return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {

        try {
//            return namedJdbc.query(SQL_GET_BOOKS_BY_ID,
//                    new MapSqlParameterSource("id", author.getId()),
//                    (rs, rw) -> (getBook(rs)));

            if (author != null)
                return em.createQuery("SELECT b FROM Book b", Book.class)
                        .getResultList()
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(book -> book.getAuthors() != null)
                        .filter(book -> book.getAuthors().equals(author.getName()))
                        .collect(Collectors.toList());
            else
                return null;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        try {
//            return namedJdbc.query(SQL_GET_BOOKS_BY_AUTHOR,
//                    new MapSqlParameterSource("title", title),
//                    (rs, rw) -> (getBook(rs)));
            return em.createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList()
                    .stream()
                    .filter((b) -> b.getTitle().equals(title))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public Optional<Book> getBookById(Long id) {
        try {
//            return namedJdbc.queryForObject(SQL_GET_BOOKS_BY_ID,
//                    new MapSqlParameterSource("id", id),
//                    (rs, rw) -> Optional.of(getBook(rs)));

//            TypedQuery<Genre> query = em
//                    .createQuery("SELECT g FROM Genre g WHERE g.genreName = :name", Genre.class);
//            query.setParameter("name", genreName);
//
//            return Optional.ofNullable(query.getSingleResult());


            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.id = :id", Book.class);
            query.setParameter("id", id);
            return Optional.ofNullable(query.getSingleResult());
        } catch (DataAccessException e) {
            return Optional.empty();
        }

    }


    @Override
    public int addNewBook(Book book) {
////        KeyHolder keyHolder = new GeneratedKeyHolder();
//
////        int status = 0;
//
//        try {
////            status += namedJdbc.update(SQL_INSERT_NEW_BOOK,
////                    new MapSqlParameterSource()
////                            .addValue("title", book.getTitle())
////                            .addValue("genre_id", book.getGenre().getId()),
////                    keyHolder, new String[]{"id"}
////            );
//        } catch (DataAccessException e) {
//            return 0;
//        }
////        Long bookId = Objects.requireNonNull(keyHolder.getKey()).longValue();
////        try {
//////            status += namedJdbc.update(SQL_INSERT_INTO_BOOK_AUTHORS,
//////                    new MapSqlParameterSource()
//////                            .addValue("a_id", book.getAuthors().getId())
//////                            .addValue("b_id", bookId));
////        } catch (DataAccessException e) {
////            return 0;
////        }
//        if (status == 2)
//            return 1;
//        else
//            return 0;

        try {
            em.persist(book);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public int updateBookTitleById(Long id, String newTitle) {

        try {
//            return namedJdbc.update(SQL_UPDATE_BOOK_TITLE_BY_ID,
//                    new MapSqlParameterSource()
//                            .addValue("id", id)
//                            .addValue("title", newTitle));

            Book book = em.find(Book.class, id);
            if (book != null) {
                book.setTitle(newTitle);
                return 1;
            } else
                return 0;


        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public int deleteBookById(Long id) {
        try {
//            return namedJdbc.update(
//                    SQL_DELETE_BOOK_BY_ID,
//                    new MapSqlParameterSource()
//                            .addValue("id", id)
//            );

            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
                return 1;
            } else
                return 0;

        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public int deleteAll() {
        try {
//            namedJdbc.getJdbcOperations()
//                    .update(SQL_DELETE_BOOKS);
//            return namedJdbc.getJdbcOperations()
//                    .update(SQL_DELETE_BOOKS_AUTHORS);
          em.createQuery("DELETE FROM Book").executeUpdate();
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

//    private Book getBook(ResultSet rs) throws SQLException {
//        return new Book(
//                rs.getLong("id"),
//                new Author(
//                        rs.getLong("authors.id"),
//                        rs.getString("author_name")),
//
//                rs.getString("title"),
//                new Genre(
//                        rs.getLong("genres.id"),
//                        rs.getString("genre_name"))
//        );
//    }
}
