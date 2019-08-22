package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */
public interface CommentDAO {

    /**
     * Create boolean.
     *
     * @param comment the comment
     * @return the boolean
     */
    boolean create(Comment comment);

    /**
     * Gets comments by book id.
     *
     * @param id the id
     * @return the comments by book id
     */
    List<Comment> getCommentsByBookId(long id);

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(long id);
}
