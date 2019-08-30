package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 30.08.2019
 * Time: 14:50.
 */

public interface BookService {

    List<Book> getAllBooks();

    List<String> getAllAuthorsNames();

    List<String> getAllGenres();

    List<Book> getBooksByAuthorsName(String name);

    List<List<Comment>> getAllComments(String bookId);

    boolean addBook(Book book);

    boolean addComment(String bookId, String comment);

    boolean updateBookTitleById(String id, String newTitle);

    boolean deleteBookById(String bookId);

    boolean deleteCommentById(String bookId);

    void deleteAll();
}
