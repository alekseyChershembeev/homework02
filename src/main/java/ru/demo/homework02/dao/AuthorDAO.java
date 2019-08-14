package ru.demo.homework02.dao;

import java.util.*;
import ru.demo.homework02.entity.Author;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 10:49.
 */

public interface AuthorDAO {

    List<String> getAllAuthorsNames();
    Optional<Author> getAuthorByName(String name);
    Optional<Author> getAuthorById(Long id);
    int addNewAuthor(Author author);
    int deleteAuthor(Author author);
    int deleteAuthorById(Long id);
    int deleteAll();
    Author addAuthorObject(Author author);

}
