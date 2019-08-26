package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.repository.AuthorRepository;
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
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    private Author author;

    @BeforeEach
    void init() {
        author = new Author();
        author.setAuthorName("Name");
        author.setAuthorLastName("LastName");
    }


    @Test
    void create() {
        authorService.save(author);
    }

    @Test
    void update() {
        authorService.save(author);
        author.setAuthorName("Name2");
        authorService.save(author);

    }

    @Test
    void getById() {
        authorService.save(author);
        authorService.getById(1L);
    }

    @Test
    void getAll() {
        authorService.save(author);
        authorService.findAll();
    }

//    @Test
//    void delete() {
////        authorService.save(author);
////        authorService.delete(1L);
//
//    }
}