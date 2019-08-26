package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.repository.AuthorRepository;
import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import java.util.Optional;
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
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    /**
     * Instantiates a new Author service.
     *
     * @param authorRepository the author dao
     */
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional()
    @Override
    public Long save(Author author) {
//        return authorDAO.create(author);
        return authorRepository.save(author).getAuthorId();
    }

//    @Transactional()
//    @Override
//    public boolean update(Author author) {
////        return authorDAO.update(author);
//        return authorDAO.
//    }

    @Override
    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Transactional()
    @Override
    public boolean deleteAuthorById(Long id) {
       return authorRepository.deleteAuthorByAuthorId(id)>0;
    }
}
