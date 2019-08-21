package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 19:10.
 */
@Repository
@Transactional
public class GenreDaoImpl implements GenreDAO{

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public GenreDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public long create(Genre genre) {
        em.persist(genre);
        return genre.getGenreId();
    }

    @Override
    public void update(Genre genre) {
        Genre currentAuthor = em.find(Genre.class, genre.getGenreId());
        if (currentAuthor!=null)
        {
            currentAuthor.setGenreName(genre.getGenreName());
        }

    }

    @Override
    public Genre getById(long id) {
        TypedQuery<Genre>query = em.createQuery("SELECT g FROM Genre g WHERE g.genreId =:id ",Genre.class);
        query.setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    public List<Genre> getAll()
    {
        TypedQuery<Genre>query = em.createQuery("SELECT g FROM Genre g",Genre.class);
        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Query query = em.createQuery("DELETE FROM Genre WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
