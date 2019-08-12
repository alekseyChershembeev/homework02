package ru.demo.homework02.service;


import java.util.*;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;

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

    boolean addNewGenre(Genre genre);
    boolean addNewBook(Book book);
    boolean addNewAuthor(Author author);

    boolean updateBookTitleById(Long id, String newTitle);

    boolean deleteBookById(Long id);
    boolean deleteAuthorById(Long id);
    boolean deleteGenre(String genreName);
    boolean deleteAll();
}
