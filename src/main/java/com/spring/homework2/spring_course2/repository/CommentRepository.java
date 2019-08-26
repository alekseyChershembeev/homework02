package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Comment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:08.
 */
@Repository
@Transactional
public interface CommentRepository extends CrudRepository<Comment,Long> {

    /**
     * Find by book book id is list.
     *
     * @param id the id
     * @return the list
     */
    List<Comment>findByBookBookIdIs(Long id);

    int deleteCommentByCommentId(Long id);
}
