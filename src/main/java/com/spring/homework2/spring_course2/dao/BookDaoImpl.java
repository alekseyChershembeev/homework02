package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:10.
 */

@Transactional
@Repository
public class BookDaoImpl implements BookDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long create(Book book) {
        em.persist(book);
        return book.getBookId();
    }

    @Override
    public void update(Book book) {

        Book currentBook = em.find(Book.class, book.getBookId());
        if (currentBook!=null)
        {
            currentBook.setBookAuthor(book.getBookAuthor());
            currentBook.setBookName(book.getBookName());
            currentBook.setBookGenre(book.getBookGenre());

        }
    }

    @Override
    public Book getById(long id) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE bookId = :id", Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Query query = em.createQuery("DELETE FROM Book WHERE bookId = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
