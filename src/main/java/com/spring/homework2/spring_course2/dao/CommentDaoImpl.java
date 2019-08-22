package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.exceptions.BookException;
import com.spring.homework2.spring_course2.exceptions.CommentException;
import java.util.List;
import javax.persistence.EntityManager;
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
public class CommentDaoImpl implements CommentDAO {

    private static final Logger LOGGER = Logger.getLogger(CommentDaoImpl.class.getName());

    private EntityManager em;

    @Autowired
    public CommentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean create(Comment comment) {
        try {
            em.persist(comment);
            return true;
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("create ") + comment.toString());
            return false;
        }

    }

    @Override
    public List<Comment> getCommentsByBookId(long id) {
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c WHERE id =: id"
                , Comment.class);
        query.setParameter("id", id);

        try {
            return query.getResultList();
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("getCommentsByBookId ") + id);
            return null;
        }
    }

    @Transactional
    @Override
    public boolean delete(long id) {

        try {
            Comment comment = em.find(Comment.class, id);
            if (comment != null) {
                em.remove(comment);
                return true;
            }
        } catch (RuntimeException ex) {
            LOGGER.error(ex.getMessage() + "\n" + new CommentException("delete ") + id);
            return false;
        }
        return false;

    }
}
