package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.CommentDAO;
import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:41.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;


    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void create(Comment comment) {
        commentDAO.create(comment);
    }

    @Override
    public List<Comment> getByBookId(long id) {
        return commentDAO.getCommentsByBookId(id);
    }

    @Override
    public void delete(long id) {
        commentDAO.delete(id);
    }
}
