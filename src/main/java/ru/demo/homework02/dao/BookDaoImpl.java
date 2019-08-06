package ru.demo.homework02.dao;

import java.util.List;
import ru.demo.homework02.entity.Book;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:06.
 */

public class BookDaoImpl implements BookDAO {
    @Override
    public List<String> getAllTitles() {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(AuthorDAO author) {
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book addNewBook(Book book) {
        return null;
    }

    @Override
    public int updateBookTitleById(Long id, String newTitle) {
        return 0;
    }

    @Override
    public int deleteBookById(Long id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
