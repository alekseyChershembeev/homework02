package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Genre;
import com.spring.homework2.spring_course2.exceptions.CommentException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:10.
 */
@Repository
public class GenreDaoImpl implements GenreDAO {

    private static final Logger LOGGER = Logger.getLogger(GenreDaoImpl.class.getName());

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public GenreDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public long create(Genre genre) {
        try {
            em.persist(genre);
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("delete ") + genre.toString());
            return 0;
        }
        return genre.getGenreId();
    }

    @Override
    public boolean update(Genre genre) {
        Genre currentAuthor;
        try {
            currentAuthor = em.find(Genre.class, genre.getGenreId());
            if (currentAuthor != null) {
                currentAuthor.setGenreName(genre.getGenreName());
                return true;
            }
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("update ") + genre.toString());
            return false;
        }
        return false;

    }

    @Override
    public Genre getById(long id) {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g WHERE g.genreId =:id ", Genre.class);
        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("getById ") + id);
            return null;
        }
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g", Genre.class);
        try {
            return query.getResultList();
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("getAll "));
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Query query = em.createQuery("DELETE FROM Genre WHERE id = :id");
        query.setParameter("id", id);
        try {
            if (em.find(Genre.class,id)!=null) {
                query.executeUpdate();
                return true;
            }
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("delete ") + id);
            return false;
        }
        return false;
    }
}
