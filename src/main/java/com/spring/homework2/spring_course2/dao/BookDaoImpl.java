package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.exceptions.BookException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:10.
 */

@Repository
public class BookDaoImpl implements BookDAO {

    private static final Logger LOGGER = Logger.getLogger(BookDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Override
    public long create(Book book) {
        try {
            em.persist(book);
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" +new BookException("created"));
            return 0;
        }
        return book.getBookId();
    }

    @Override
    public boolean update(Book book) {

        Book currentBook;
        try {
            currentBook = em.find(Book.class, book.getBookId());
            currentBook.setBookAuthor(book.getBookAuthor());
            currentBook.setBookName(book.getBookName());
            currentBook.setBookGenre(book.getBookGenre());
            return true;
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new BookException("getById"));
            return false;
        }

    }

    @Override
    public Book getById(long id) {
        try {
            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE bookId = :id", Book.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new BookException("getById"));
            return null;
        }

    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        try {
            return query.getResultList();
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new BookException("getAll"));
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Query query = em.createQuery("DELETE FROM Book WHERE bookId = :id");
        query.setParameter("id", id);
        try {
            query.executeUpdate();
            return true;
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new BookException("delete ")+ id);
            return false;
        }
    }
}
