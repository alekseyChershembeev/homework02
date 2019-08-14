package ru.demo.homework02.dao;

import java.util.*;
import ru.demo.homework02.entity.Genre;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 10:50.
 */

public interface GenreDAO {

    List<Genre> getAllGenres();
    Optional<Genre> getGenreByName(String genreName);
    Genre addGenreObject(Genre genre);
    int addGenre(Genre genre);
    int deleteGenre(Genre genre);
    int deleteAll();
}
