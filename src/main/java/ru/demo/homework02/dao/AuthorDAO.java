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
    Author getAuthorByName(String name);
    Author getAuthorById(Long id);
    Author addNewAuthor(Author author);
    int deleteAuthor(Author author);
    int deleteAuthorById(Long id);
    int deleteAll();

}
