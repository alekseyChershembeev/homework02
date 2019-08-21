package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.dao.AuthorDAO;
import com.spring.homework2.spring_course2.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Import(AuthorServiceImpl.class)
public class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @MockBean
    private AuthorDAO authorDAO;

    private Author author;

    @BeforeEach
    void init() {
        author = new Author();
        author.setAuthorName("Name");
        author.setAuthorLastName("LastName");
    }


    @Test
    void create() {
        authorService.create(author);
    }

    @Test
    void update() {
        authorService.create(author);
        author.setAuthorName("Name2");
        authorService.update(author);

    }

    @Test
    void getById() {
        authorService.create(author);
        authorService.getById(1L);
    }

    @Test
    void getAll() {
        authorService.create(author);
        authorService.getAll();
    }

    @Test
    void delete() {
        authorService.create(author);
        authorService.delete(1L);

    }
}