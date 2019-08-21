package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.GenreDAO;
import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:41.
 */
@Service
public class GenreServiceImpl implements GenreService {

    private GenreDAO genreDAO;

    @Autowired
    public GenreServiceImpl(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    public long create(Genre genre) {
        return genreDAO.create(genre);
    }

    @Override
    public void update(Genre genre) {
        genreDAO.update(genre);
    }

    @Override
    public Genre getById(long id) {
        return genreDAO.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreDAO.getAll();
    }

    @Override
    public void delete(long id) {
        genreDAO.delete(id);
    }

}
