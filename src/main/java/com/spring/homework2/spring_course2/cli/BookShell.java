package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Genre;
import com.spring.homework2.spring_course2.service.BookService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:38.
 */
@ShellComponent

public class BookShell {

    /**
     * Instantiates a new Book shell.
     *
     * @param bookService the book service
     */
    @Autowired
    public BookShell(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;

    /**
     * Gets all books names.
     *
     * @return the all books names
     */
    @ShellMethod(value = "show all Books names", key = "all-books")
    public List<Book> getAllBooksNames() {
        return bookService.getAll();
    }


//    @ShellMethod(value = "show all books by Author name", key = "all-books-name")
//    public String getBooksByAuthorsName
//            (@ShellOption(help = "author name") String name,
//             @ShellOption(help = "author lastName") String lastName) {
//
//        return bookService.getBooksByAuthorsName(new Author(name, lastName)).toString();
//    }


    /**
     * Add new book string.
     *
     * @param genre          the genre
     * @param name           the name
     * @param authorName     the author name
     * @param authorLastName the author last name
     * @return the string
     */
    @ShellMethod(value = "add new Book", key = "add-book")
    public String addNewBook(@ShellOption(help = "genre") String genre,
                             @ShellOption(help = "title") String name,
                             @ShellOption(help = "authorName") String authorName,
                             @ShellOption(help = "authorLastName") String authorLastName) {
        final long isAddBook = bookService
                .create(new Book(
                        name,
                        new Author(authorName, authorLastName),
                        new Genre(genre)
                ));

        if (isAddBook > 0)
            return "New Book was added successfully";
        else
            return "Book already exist ";
    }

    /**
     * Update book by id string.
     *
     * @param id             the id
     * @param nameBook       the name book
     * @param authorName     the author name
     * @param authorLastName the author last name
     * @param genre          the genre
     * @return the string
     */
    @ShellMethod(value = "update Book", key = "update-book")
    public String updateBookById(@ShellOption(help = "id") String id,
                                 @ShellOption(help = "title") String nameBook,
                                 @ShellOption(help = "authorName") String authorName,
                                 @ShellOption(help = "authorLastName") String authorLastName,
                                 @ShellOption(help = "genre") String genre) {
        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        Book book = bookService.getById(longId);
        boolean isDelete;
        isDelete = (book != null && book.getBookId() == longId);

        if (isDelete && longId != 0) {

            book.setBookAuthor(new Author(authorName, authorLastName));
            book.setBookGenre(new Genre(genre));
            book.setBookName(nameBook);
            bookService
                    .update(book);
            return "Book was update successfully";
        } else
            return "Book doesn't exist";
    }

    /**
     * Delete book by id string.
     *
     * @param id the id
     * @return the string
     */
    @ShellMethod(value = "delete Book by id", key = "delete-book")
    public String deleteBookById(@ShellOption(help = "id") String id) {

        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        Book book = bookService.getById(longId);
        boolean isDelete;
        isDelete = (book != null && book.getBookId() == longId);

        if (isDelete) {
            bookService
                    .delete(Long.parseLong(id));

            return "Book was delete successfully";
        }
        else
            return "Book doesn't exist";
    }


}
