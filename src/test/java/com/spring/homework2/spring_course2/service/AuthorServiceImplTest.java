package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.repository.AuthorRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Import(AuthorServiceImpl.class)
public class AuthorServiceImplTest {

    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;


    private Author author;


    @BeforeEach
    public void init() {
        authorService = new AuthorServiceImpl(authorRepository);
        author = new Author();
        author.setAuthorName("Name");
        author.setAuthorLastName("LastName");
    }


    @Test
    public void create() {
        authorService.save(author);
    }

    @Test
    public void update() {
        authorService.save(author);
        author.setAuthorName("Name2");
        authorService.save(author);
    }

    @Test
    public void getById() {
        authorService.save(author);
        authorService.getById(1L);
    }

    @Test
    public void getAll() {
        authorService.save(author);
        authorService.findAll();
    }

    @Test
    public void delete() {
        Long id = authorService.save(author);
        authorService.deleteAuthorById(id);
    }
}