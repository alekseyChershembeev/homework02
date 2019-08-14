package ru.demo.homework02.dao;


import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import java.util.Optional;
import java.util.List;
import ru.demo.homework02.entity.Author;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:06.
 */
@Repository
public class AuthorDaoImpl implements AuthorDAO {

    private final NamedParameterJdbcOperations namedJDBC;

    /**
     * Instantiates a new Author dao.
     *
     * @param namedJDBC the named jdbc
     */
    @Autowired
    public AuthorDaoImpl(NamedParameterJdbcOperations namedJDBC) {
        this.namedJDBC = namedJDBC;
    }


    private static final String SQL_GET_ALL_AUTHORS_NAMES = "SELECT author_name FROM authors";
    private static final String SQL_AUTHOR_BY_NAME = "SELECT * FROM authors WHERE author_name = :name";
    private static final String SQL_GET_AUTHOR_BY_ID = "SELECT * FROM authors WHERE id= :id";
    private static final String SQL_ADD_NEW_AUTHOR = "INSERT INTO authors (author_name) VALUES (:name)";
    private static final String SQL_DELETE_AUTHOR = "DELETE FROM authors WHERE author_name=:name";
    private static final String SQL_DELETE_AUTHOR_BY_ID = "delete from authors where id=:id";
    private static final String SQL_DELETE_ALL = "DELETE FROM books_authors";


    @Override
    public List<String> getAllAuthorsNames() {
        return namedJDBC
                .getJdbcOperations()
                .queryForList(SQL_GET_ALL_AUTHORS_NAMES, String.class);
    }

    @Override
    public Optional<Author> getAuthorByName(String name) {

        try {
            return namedJDBC.queryForObject(SQL_AUTHOR_BY_NAME,
                    new MapSqlParameterSource("name", name),
                    (rs, rowNum) -> Optional.of(new Author(
                            rs.getLong("id"),
                            rs.getString("author_name")
                    )));
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Author> getAuthorById(Long id) {

        try {
            return namedJDBC.queryForObject(SQL_GET_AUTHOR_BY_ID,
                    new MapSqlParameterSource("id", id),
                    (rs, rowNum) -> Optional.of(new Author(
                            rs.getLong("id"),
                            rs.getString("author_name")
                    )));
        }
        catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    //возвр 1 если успех
    @Override
    public int addNewAuthor(Author author) {
        try {
            return namedJDBC.update(SQL_ADD_NEW_AUTHOR,
                    new BeanPropertySqlParameterSource(author),
                    new GeneratedKeyHolder(),
                    new String[]{"id"});
        } catch (DataAccessException e) {
            return 0;
        }

    }

    @Override
    public int deleteAuthor(Author author) {
        try {
            return namedJDBC.update(SQL_DELETE_AUTHOR,
                    new MapSqlParameterSource("id", author.getId()));
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public int deleteAuthorById(Long id) {
        try {
            return namedJDBC.update(SQL_DELETE_AUTHOR_BY_ID,
                    new MapSqlParameterSource("id", id));
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public int deleteAll() {
        try {
            return namedJDBC.getJdbcOperations().update(SQL_DELETE_ALL);
        } catch (DataAccessException e) {
            return 0;
        }
    }


    @Override
    public Author addAuthorObject(Author author) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            namedJDBC.update(SQL_ADD_NEW_AUTHOR,
                    new MapSqlParameterSource()
                            .addValue("name", author.getName()),
                    keyHolder,
                    new String[]{"id"});
        } catch (DataAccessException e) {
            return null;
        }

        author.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return author;

    }

}


