package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.repository.GenreRepository;
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

    private GenreRepository genreRepository;

    /**
     * Instantiates a new Genre service.
     *
     * @param genreRepository the genre dao
     */
    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional()
    @Override
    public long create(Genre genre) {
        return genreRepository.save(genre).getGenreId();
    }

//    @Transactional()
//    @Override
//    public boolean update(Genre genre) {
//        return genreDAO.save(genre.ge);
//    }

    @Override
    public Genre getById(long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> getAll() {
        return (List<Genre>) genreRepository.findAll();
    }

    @Transactional()
    @Override
    public boolean delete(long id) {
        return genreRepository.deleteGenreByGenreId(id)>0;
    }

}
