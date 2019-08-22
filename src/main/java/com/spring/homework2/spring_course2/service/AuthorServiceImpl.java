package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.AuthorDAO;
import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
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

    private AuthorDAO authorDAO;

    /**
     * Instantiates a new Author service.
     *
     * @param authorDAO the author dao
     */
    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Transactional()
    @Override
    public long create(Author author) {
        return authorDAO.create(author);
    }

    @Transactional()
    @Override
    public boolean update(Author author) {
        return authorDAO.update(author);
    }

    @Override
    public Author getById(long id) {
        return authorDAO.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDAO.getAll();
    }

    @Transactional()
    @Override
    public boolean delete(long id) {
       return authorDAO.delete(id);
    }
}
