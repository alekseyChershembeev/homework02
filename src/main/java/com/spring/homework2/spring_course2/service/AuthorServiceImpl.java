package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.AuthorDAO;
import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:41.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public long create(Author author) {
        return authorDAO.create(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public Author getById(long id) {
        return authorDAO.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDAO.getAll();
    }

    @Override
    public void delete(long id) {
        authorDAO.delete(id);
    }
}
