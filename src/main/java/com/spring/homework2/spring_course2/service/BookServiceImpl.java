package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.BookDAO;
import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:41.
 */
@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    /**
     * Instantiates a new Book service.
     *
     * @param bookDAO the book dao
     */
    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Transactional()
    @Override
    public long create(Book book) {
        return bookDAO.create(book);
    }

    @Transactional()
    @Override
    public boolean update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public Book getById(long id) {
        return bookDAO.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Transactional()
    @Override
    public boolean delete(long id) {

        return bookDAO.delete(id);


//    @Override
//    public List<Book> getBooksByAuthorsName(Author author) {
//
//        return bookDAO.getAll().stream()
//                .flatMap(Stream::ofNullable)
//                .filter((s) -> s.getBookAuthor() != null)
//                .filter((s) -> s.getBookAuthor().getAuthorName() != null)
//                .filter(s2 -> s2.getBookAuthor().getAuthorName().equals(author.getAuthorName()))
//                .filter((s) -> s.getBookAuthor().getAuthorLastName() != null)
//                .filter(s2 -> s2.getBookAuthor().getAuthorLastName().equals(author.getAuthorLastName()))
//                .collect(Collectors.toList());
//    }
    }
}
