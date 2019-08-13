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

    boolean addNewGenre(Genre genre);
    boolean addNewBook(Book book);
    boolean addNewAuthor(Author author);

    boolean updateBookTitleById(Long id, String newTitle);

    boolean deleteBookById(Long id);
    boolean deleteAuthorById(Long id);
    boolean deleteGenre(String genreName);
    boolean deleteAll();

    String getTableFromList(List<Book>list);
}
