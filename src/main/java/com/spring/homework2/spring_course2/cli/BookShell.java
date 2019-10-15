package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import java.util.List;

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
    public BookShell(final BookService bookService) {
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
        return bookService.getAllBooks();
    }


    /**
     * Add new book string.
     *
     * @param genre      the genre
     * @param name       the name
     * @param authorName the author name
     * @return the string
     */
    @ShellMethod(value = "add new Book", key = "add-book")
    public String addNewBook(
            final @ShellOption(help = "genre") String genre,
            final @ShellOption(help = "title") String name,
            final @ShellOption(help = "authorName") String authorName) {

        if (bookService
                .addBook(new Book(name, authorName, genre
                ))) {
            return "New Book was added successfully";
        } else {
            return "Book already exist ";
        }
    }

    /**
     * Update book by id string.
     *
     * @param id         the id
     * @param nameBook   the name book
     * @param authorName the author name
     * @param genre      the genre
     * @return the string
     */
    @ShellMethod(value = "update Book", key = "update-book")
    public String updateBookById(
            final @ShellOption(help = "id") String id,
            final @ShellOption(help = "title") String nameBook,
            final @ShellOption(help = "authorName") String authorName,
            final @ShellOption(help = "genre") String genre) {

        if ((bookService
                .updateBookById(id, nameBook, authorName, genre)
                )) {
            return "Book was update successfully";
        }
        else {
            return "Book doesn't exist";
        }
    }

    /**
     * Delete book by id string.
     *
     * @param id the id
     * @return the string
     */
    @ShellMethod(value = "delete Book by id", key = "delete-book")
    public String deleteBookById(final @ShellOption(help = "id") String id) {


        if (bookService
                .deleteBookById(id)) {
            return "Book was delete successfully";
        } else {
            return "Book doesn't exist";
        }
    }


    /**
     * Gets all authors names.
     *
     * @return the all authors names
     */
    @ShellMethod(value = "show all Authors names", key = "all-authors")
    public List<String> getAllAuthorsNames() {
        return bookService.getAllAuthorsNames();
    }


    /**
     * Add new comment.
     *
     * @param bookId  the book id
     * @param comment the comment
     * @return the comments
     */
    @ShellMethod(value = "add new Comment", key = "add-comment")
    public String addNewComment(
            final @ShellOption(help = "bookId") String bookId,
            final @ShellOption(help = "comment") String comment) {


        if (bookId.matches("\\d+") && bookService.addComment(bookId, comment)) {
            return "Comment was add successfully";
        }

        return "Comment doesn't exist";
    }

    /**
     * Gets comments.
     *
     * @param id the id
     * @return the comments
     */
    @ShellMethod(value = "show comments to Book", key = "show-comments")
    public String getComments(final @ShellOption(help = "id book") String id) {

        return bookService.getAllComments(id).toString();
    }

    /**
     * Delete comment string.
     *
     * @param id the id
     * @return the string
     */
    @ShellMethod(value = "delete Comment by id", key = "delete-comment")
    public String deleteComment(
            final @ShellOption(help = "id comment") String id) {


        if (id.matches("\\d+")) {
            return "Comment was delete successfully";
        } else {
            return "Comment doesn't exist";
        }
    }


    /**
     * Gets all genres.
     *
     * @return the all genres
     */
    @ShellMethod(value = "show all genres", key = "all-genres")
    public List<String> getAllGenres() {
        return bookService.getAllGenres();
    }


}
