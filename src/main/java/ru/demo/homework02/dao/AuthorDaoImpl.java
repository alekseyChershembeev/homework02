package ru.demo.homework02.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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

    private NamedParameterJdbcOperations namedJDBC;

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

        return namedJDBC.queryForObject(SQL_AUTHOR_BY_NAME,
                new MapSqlParameterSource("name", name),
                (rs, rowNum) -> Optional.of(new Author(
                        rs.getLong("id"),
                        rs.getString("author_name")
                )));
    }


    @Override
    public Optional<Author> getAuthorById(Long id) {

        return namedJDBC.queryForObject(SQL_GET_AUTHOR_BY_ID,
                new MapSqlParameterSource("id", id),
                (rs, rowNum) -> Optional.of(new Author(
                        rs.getLong("id"),
                        rs.getString("author_name")
                )));
    }

    //возвр 1 если успех
    @Override
    public int addNewAuthor(Author author) {
                return namedJDBC.update(SQL_ADD_NEW_AUTHOR,
                new BeanPropertySqlParameterSource(author),
                        new GeneratedKeyHolder(),
                        new String[] { "id" });

    }

    @Override
    public int deleteAuthor(Author author) {
        return namedJDBC.update(SQL_DELETE_AUTHOR,
                new MapSqlParameterSource("id",author.getId()));
    }

    @Override
    public int deleteAuthorById(Long id) {
        return namedJDBC.update(SQL_DELETE_AUTHOR_BY_ID,
                new MapSqlParameterSource("id",id));
    }

    @Override
    public int deleteAll() {
        return namedJDBC.getJdbcOperations().update(SQL_DELETE_ALL);
    }
}


