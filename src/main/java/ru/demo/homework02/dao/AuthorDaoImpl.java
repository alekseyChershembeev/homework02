package ru.demo.homework02.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
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
        this.namedJDBC =  namedJDBC;
    }


    private static final String SQL_GET_ALL_AUTHORS_NAMES = "select author_name from authors";
    private static final String SQL_AUTHOR_BY_NAME = "select * from authors where author_name:=name";
    private static final String SQL_GET_AUTHOR_BY_ID = "select author_name from authors where id:=id";
    private static final String SQL_GET_ADD_NEW_AUTHOR = "insert into authors (author_name) values (name)";
    private static final String SQL_DELETE_AUTHOR = "delete from authors where author_name:=name";
    private static final String SQL_DELETE_AUTHOR_BY_ID = "delete from authors where id:=id";
    private static final String SQL_DELETE_ALL = "delete from books_authors";

    @Override
    public List<String> getAllAuthorsNames() {
        return namedJDBC
                .getJdbcOperations()
                .queryForList(SQL_GET_ALL_AUTHORS_NAMES, String.class);
    }

    @Override
    public Author getAuthorByName(String name) {
        return null;
    }


    @Override
    public Author getAuthorById(Long id) {
//        return namedJDBC.queryForObject();
        return null;
    }

    @Override
    public Author addNewAuthor(Author author) {
        return null;
    }

    @Override
    public int deleteAuthor(Author author) {
        return 0;
    }

    @Override
    public int deleteAuthorById(Long id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}


