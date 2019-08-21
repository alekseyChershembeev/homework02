package com.spring.homework2.spring_course2.dao;


import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:45.
 */
@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDAO {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public AuthorDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public long create(Author author) {
        em.persist(author);
        return author.getAuthorId();
    }

    @Override
//    @Modifying(clearAutomatically = true)
    public void update(Author author) {
        Author currentAuthor = em.find(Author.class, author.getAuthorId());
        if (currentAuthor!=null)
        {
            currentAuthor.setAuthorName(author.getAuthorName());
            currentAuthor.setAuthorLastName(author.getAuthorLastName());
        }


        //"update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId"
//        TypedQuery<Author> query = em.createQuery("UPDATE Author a SET" +
//                        " a.authorName =:name, a.authorLastName =: lastName " +
//                        "WHERE a.authorId =:id",
//                Author.class);
//        query.setParameter("id", author.getAuthorId());
//        query.setParameter("name", author.getAuthorName());
//        query.setParameter("lastName", author.getAuthorLastName());
//        query.executeUpdate();


    }

    @Override
    public Author getById(long id) {

        TypedQuery<Author> query = em.createQuery("SELECT a from Author a where id = :id", Author.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("SELECT a from Author a", Author.class);
        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Query query = em.createQuery("DELETE from Author where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
