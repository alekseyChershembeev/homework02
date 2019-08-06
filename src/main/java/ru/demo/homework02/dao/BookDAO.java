package ru.demo.homework02.dao;

import java.util.List;
import ru.demo.homework02.entity.Book;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 10:49.
 */

public interface BookDAO {


    List<String> getAllTitles();
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(AuthorDAO author);
    List<Book> getBooksByTitle(String title);
    Book getBookById(Long id);
    Book addNewBook(Book book);
    int updateBookTitleById(Long id, String newTitle);
    int deleteBookById(Long id);
    int deleteAll();
}
