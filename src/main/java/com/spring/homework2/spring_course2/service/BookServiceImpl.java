package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Chershembeev_AE
 * Date: 30.08.2019
 * Time: 14:50.
 */

@Service

public class BookServiceImpl implements BookService {

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> getAllAuthorsNames() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllGenres() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getGenre)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthorsName(String name) {
        return bookRepository.findAll()
                .stream()
                .filter((b) -> b.getAuthor().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findBookById(String bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<List<Comment>> getAllComments(String bookId) {
        return bookRepository.findAll()
                .stream()
                .filter(b -> b.getId().equals(bookId))
                .map(Book::getComments)
                .collect(Collectors.toList());

    }

    @Override
    public boolean addBook(Book book) {
        book = bookRepository.save(book);
        return book.getId() != null;
    }

    @Override
    public boolean addComment(String bookId, String comment) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            book.get().getComments().add(new Comment(comment));
            bookRepository.save(book.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBookTitleById(String id, String newTitle) {

        Optional<Book> book = bookRepository.findById(id);

        book.ifPresent(b -> {
            book.get().setTitle(newTitle);
            bookRepository.save(book.get());
        });

        return book.isPresent();
    }

    @Override
    public boolean deleteBookById(String bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            Book book1 = book.get();
            bookRepository.delete(book1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCommentById(String bookId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setComments(null);
            bookRepository.save(book1);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {

        bookRepository.deleteAll();

    }
}
