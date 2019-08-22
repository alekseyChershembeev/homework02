package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.CommentDAO;
import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:41.
 */
@Service
@Transactional(readOnly=true)
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;


    /**
     * Instantiates a new Comment service.
     *
     * @param commentDAO the comment dao
     */
    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Transactional()
    @Override
    public boolean create(Comment comment) {
        return commentDAO.create(comment);
    }

    @Override
    public List<Comment> getByBookId(long id) {
        return commentDAO.getCommentsByBookId(id);
    }

    @Transactional()
    @Override
    public boolean delete(long id) {
        return commentDAO.delete(id);
    }
}
