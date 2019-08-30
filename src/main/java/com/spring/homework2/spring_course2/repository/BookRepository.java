package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Chershembeev_AE
 * Date: 30.08.2019
 * Time: 14:49.
 */

public interface BookRepository extends MongoRepository<Book, String> {




}
