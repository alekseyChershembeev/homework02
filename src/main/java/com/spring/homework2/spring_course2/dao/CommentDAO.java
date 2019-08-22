package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */

public interface CommentDAO {

    boolean create(Comment comment);

    List<Comment> getCommentsByBookId(long id);

    boolean delete(long id);
}
