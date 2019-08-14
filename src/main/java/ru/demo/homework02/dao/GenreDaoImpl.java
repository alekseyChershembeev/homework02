package ru.demo.homework02.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.demo.homework02.entity.Genre;
import java.util.*;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:06.
 */

@Repository
public class GenreDaoImpl implements GenreDAO {

    private final NamedParameterJdbcTemplate namedJdbc;

    private static final String SQL_GET_ALL_GENRES =
            "SELECT * FROM genres";
    private static final String SQL_GET_GENRE_BY_NAME =
            "SELECT * FROM genres " +
                    "WHERE genre_name =:genre_name";
    private static final String SQL_DELETE_GENRE =
            "DELETE FROM genres WHERE id =:id";
    private static final String SQL_ADD_GENRE =
            "INSERT INTO genres (genre_name) VALUES (:genreName);";
    private static final String SQL_DELETE_GENRE_ID =
            "UPDATE books SET genre_id = null WHERE genre_id = :id";
    private static final String SQL_DELETE_NULL_GENRE_ID =
            "UPDATE books SET genre_id = null";
    private static final String SQL_DELETE_ALL =
            "DELETE FROM genres";


    @Autowired
    public GenreDaoImpl(NamedParameterJdbcTemplate namedJdbc) {
        this.namedJdbc = namedJdbc;
    }


    @Override
    public List<Genre> getAllGenres() {
        return namedJdbc.query(SQL_GET_ALL_GENRES,
                (rs, rw) -> new Genre(
                        rs.getLong("id"),
                        rs.getString("genre_name")
                )
        );
    }

    @Override
    public Optional<Genre> getGenreByName(String genreName) {
        return namedJdbc.queryForObject(SQL_GET_GENRE_BY_NAME,
                new MapSqlParameterSource("genre_name", genreName),
                (rs, rowNum) -> Optional.of(new Genre(
                        rs.getLong("id"),
                        rs.getString("genre_name")
                )));
    }

    @Override
    public int addGenre(Genre genre) {

        return namedJdbc.update(SQL_ADD_GENRE,
                new BeanPropertySqlParameterSource(genre),
                new GeneratedKeyHolder(),
                new String[]{"id"});
    }

    @Override
    public int deleteGenre(Genre genre) {
        namedJdbc.update(SQL_DELETE_GENRE_ID,
                new MapSqlParameterSource()
                        .addValue("id", genre.getId()));
        return namedJdbc.update(SQL_DELETE_GENRE,
                new MapSqlParameterSource()
                        .addValue("id", genre.getId()));
    }

    @Override
    public int deleteAll() {
        namedJdbc.getJdbcOperations()
                .update(SQL_DELETE_NULL_GENRE_ID);
        return namedJdbc.getJdbcOperations()
                .update(SQL_DELETE_ALL);
    }

    @Override
    public Genre addGenreObject(Genre genre) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbc.update(SQL_ADD_GENRE,
                new MapSqlParameterSource()
                        .addValue("genreName",
                                genre.getGenreName()),
                keyHolder,
                new String[]{"id"});
        genre.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return genre;
    }


}
