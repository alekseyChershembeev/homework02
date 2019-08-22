package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */

public interface CommentService {
    boolean create(Comment comment);

    List<Comment> getByBookId(long id);

    boolean delete(long id);
}
