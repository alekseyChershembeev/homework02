package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Author;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@SpringBootTest(properties = {
//        "spring.datasource.data=testdata.sql"
//})
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext
@Import(AuthorDaoImpl.class)
public class AuthorDaoImplTest {

    @Autowired
    AuthorDAO authorDAO;

    private Author author;

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
    public void create() {
        System.out.println(authorDAO.create(author));
        assertThat(author)
                .hasFieldOrPropertyWithValue("authorName", "VOVA2")
                .hasFieldOrPropertyWithValue("authorLastName", "PUTIN2");
    }

    @Test
    public void update() {

        authorDAO.create(author);
        author.setAuthorName("Boriska");
        author.setAuthorLastName("Elzin");
        authorDAO.update(author);
        assertThat(author)
                .hasFieldOrPropertyWithValue("authorName", "Boriska")
                .hasFieldOrPropertyWithValue("authorLastName", "Elzin");

    }

    @Test
    public void getById() {
        long id = authorDAO.create(author);

        assertThat(authorDAO.getById(id))
                .hasFieldOrPropertyWithValue("authorId", id)
                .hasFieldOrPropertyWithValue("authorName", "VOVA2")
                .hasFieldOrPropertyWithValue("authorLastName", "PUTIN2");

    }

    @Test
    public void getAll() {
        authorDAO.create(author);
        List<Author> authors = authorDAO.getAll();
        assertEquals(authors.size(), 1);
    }

    @Test
    public void delete() {
//        author.setId(1L);
//        authorDAO.create(author);
//
//        authorDAO.delete(1L);
    }
}