package ru.demo.homework02.service;

import java.awt.print.Book;
import java.util.*;
import ru.demo.homework02.dao.AuthorDAO;
import ru.demo.homework02.dao.GenreDAO;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 10:55.
 */

public interface LibraryService {

    List<Book> getAllBooks();
    List<String> getAllAuthorsNames();
    List<String> getAllGenres();
    List<Book> getBooksByAuthorsName(String name);

    boolean addNewGenre(GenreDAO genre);
    boolean addNewBook(Book book);
    boolean addNewAuthor(AuthorDAO author);

    boolean updateBookTitleById(Long id, String newTitle);

    boolean deleteBookById(Long id);
    boolean deleteAuthorById(Long id);
    boolean deleteGenre(String genreName);
    void deleteAll();
}
