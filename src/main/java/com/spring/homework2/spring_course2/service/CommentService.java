package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */
public interface CommentService {
    /**
     * Create boolean.
     *
     * @param comment the comment
     * @return the boolean
     */
    boolean create(Comment comment);

    /**
     * Gets by book id.
     *
     * @param id the id
     * @return the by book id
     */
    List<Comment> getByBookId(long id);

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(long id);
}
