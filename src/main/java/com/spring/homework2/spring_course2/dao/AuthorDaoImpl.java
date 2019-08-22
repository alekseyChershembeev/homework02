package com.spring.homework2.spring_course2.dao;


import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.exceptions.AuthorException;
import com.spring.homework2.spring_course2.exceptions.BookException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:45.
 */
@Repository

public class AuthorDaoImpl implements AuthorDAO {

    private static final Logger LOGGER = Logger.getLogger(AuthorDaoImpl.class.getName());

    @PersistenceContext
    private final EntityManager em;

    /**
     * Instantiates a new Author dao.
     *
     * @param em the em
     */
    @Autowired
    public AuthorDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public long create(Author author) {
        try {
            em.persist(author);
            return author.getAuthorId();
        } catch (RuntimeException e) {
            LOGGER.error(new AuthorException(e.getMessage() + "\n" + "created " + author.toString()));
            return 0;
        }
    }

    @Override
    public boolean update(Author author) {
        Author currentAuthor;
        try {
            currentAuthor = em.find(Author.class, author.getAuthorId());
            if (currentAuthor != null) {
                currentAuthor.setAuthorName(author.getAuthorName());
                currentAuthor.setAuthorLastName(author.getAuthorLastName());
                return true;
            }
        } catch (RuntimeException e) {
            LOGGER.error(new AuthorException("update ") + author.toString());
            return false;
        }


        //"update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId"
//        TypedQuery<Author> query = em.createQuery("UPDATE Author a SET" +
//                        " a.authorName =:name, a.authorLastName =: lastName " +
//                        "WHERE a.authorId =:id",
//                Author.class);
//        query.setParameter("id", author.getAuthorId());
//        query.setParameter("name", author.getAuthorName());
//        query.setParameter("lastName", author.getAuthorLastName());
//        query.executeUpdate();

        return false;
    }

    @Override
    public Author getById(long id) {

        TypedQuery<Author> query = em.createQuery("SELECT a from Author a where id = :id", Author.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new AuthorException("update ") + "" + id);
            return null;
        }
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("SELECT a from Author a", Author.class);
        try {
            return query.getResultList();
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new AuthorException("getAll "));
            return null;
        }
    }

    @Override
    public boolean delete(long id) {

        try {
            Query query = em.createQuery("DELETE from Author where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage() + "\n" + new AuthorException("delete " + id));
            return false;
        }
    }
}
