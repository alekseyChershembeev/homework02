package com.spring.homework2.spring_course2.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest

class BookRepositoryTest {


    private static final String TEST_TITLE_1 = "testName";
    private static final String TEST_TITLE_2 = "testName2";
    private static final String TEST_AUTHOR_1 = "testAuthor";
    private static final String TEST_AUTHOR_2 = "testAuthor2";
    private static final String TEST_GENRE_1 = "testGenre";
    private static final String TEST_GENRE_2 = "testGenre2";
    private static final String TEST_GENRE_3 = "testGenre3";
    private static final String TEST_AUTHOR_3 = "testAuthor3";
    private static final String TEST_USER_1 = "testUser";
    private static final String TEST_TEXT_1 = "testText";
    private static final String TEST_USER_2 = "testUser2";
    private static final String TEST_TEXT_2 = "testText2";


    @Autowired
    private BookRepository bookRepository;
    @BeforeEach

    void setUp() {
        bookRepository.deleteAll();
    }





}