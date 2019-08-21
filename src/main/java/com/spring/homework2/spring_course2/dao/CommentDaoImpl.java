package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:10.
 */
@Repository
@Transactional
public class CommentDaoImpl implements CommentDAO {

    private EntityManager em;

    @Autowired
    public CommentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Comment comment) {
        em.persist(comment);

    }

    @Override
    public List<Comment> getCommentsByBookId(long id) {
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c WHERE id =: id"
                , Comment.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    public boolean delete(long id) {
//        Query query = em.createQuery("DELETE from Comment where commentId = :id");
//        query.setParameter("id", id);
//        query.executeUpdate();

        Comment comment = em.find(Comment.class, id);
        if (comment != null) {
            em.remove(comment);
            return true;
        }
        return false;

    }
}
