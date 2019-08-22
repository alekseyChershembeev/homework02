package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.GenreDAO;
import com.spring.homework2.spring_course2.entity.Genre;
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
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {

    private GenreDAO genreDAO;

    /**
     * Instantiates a new Genre service.
     *
     * @param genreDAO the genre dao
     */
    @Autowired
    public GenreServiceImpl(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Transactional()
    @Override
    public long create(Genre genre) {
        return genreDAO.create(genre);
    }

    @Transactional()
    @Override
    public boolean update(Genre genre) {
        return genreDAO.update(genre);
    }

    @Override
    public Genre getById(long id) {
        return genreDAO.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreDAO.getAll();
    }

    @Transactional()
    @Override
    public boolean delete(long id) {
        return genreDAO.delete(id);
    }

}
