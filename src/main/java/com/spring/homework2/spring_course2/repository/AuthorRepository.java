package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:44.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

   /**
    * Delete author by author id int.
    *
    * @param id the id
    * @return the int
    */
   int deleteAuthorByAuthorId(Long id);
}
