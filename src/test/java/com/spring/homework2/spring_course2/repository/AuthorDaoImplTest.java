package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AuthorDaoImplTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    AuthorRepository authorRepository;
    Author author;

//    private

    @Before
    public void setUp()  {

        author = new Author();
        author.setAuthorName("VOVA2");
        author.setAuthorLastName("PUTIN2");

    }

    @After
    public void tearDown()  {
    }

    @Test
    public void save() {
        Author author = new Author();
        author.setAuthorName("VOVA2");
        author.setAuthorLastName("PUTIN2");
        System.out.println(authorRepository.save(author));
        assertThat(author)
                .hasFieldOrPropertyWithValue("authorName", "VOVA2")
                .hasFieldOrPropertyWithValue("authorLastName", "PUTIN2");
    }

    @Test
    public void update() {

        authorRepository.save(author);
        author.setAuthorName("Boriska");
        author.setAuthorLastName("Elzin");
        authorRepository.save(author);
        assertThat(author)
                .hasFieldOrPropertyWithValue("authorName", "Boriska")
                .hasFieldOrPropertyWithValue("authorLastName", "Elzin");

    }

    @Test
    public void getById() {
        long id = authorRepository.save(author).getAuthorId();

        assertThat(authorRepository.findById(id).get())
                .hasFieldOrPropertyWithValue("authorId", id)
                .hasFieldOrPropertyWithValue("authorName", "VOVA2")
                .hasFieldOrPropertyWithValue("authorLastName", "PUTIN2");

    }

    @Test
    public void getAll() {
        authorRepository.save(author);
        List<Author> authors = (List<Author>) authorRepository.findAll();
        assertEquals(authors.size(), 1);
    }
//
    @Test
    public void delete() {
//        author.setId(1L);
        authorRepository.save(author);
        authorRepository.deleteAuthorByAuthorId(1L);
    }
}