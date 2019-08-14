package ru.demo.homework02.cli;

import java.util.List;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;

/**
 * Created by Chershembeev_AE
 * Date: 13.08.2019
 * Time: 11:39.
 */

public interface LibraryShell {

    List<Book> getAllBooks();
    List<String> getAllAuthorsNames();
    List<String> getAllGenres();
    String getBooksByAuthorsName(String name);

    String addNewGenre(String genre);
    String addNewBook(String genre, String title, String author);
    String addNewAuthor(String author);

    String updateBookTitleById(Long id, String newTitle);

    String deleteBookById(Long id);
    String deleteAuthorById(Long id);
    String deleteGenre(String genreName);
    String deleteAll();

    String getTableFromList(List<Book>list);
}
