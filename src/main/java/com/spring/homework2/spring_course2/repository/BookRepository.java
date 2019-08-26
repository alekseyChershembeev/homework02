package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:43.
 */
@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book,Long> {

    int deleteBookByBookId(Long id);
}
