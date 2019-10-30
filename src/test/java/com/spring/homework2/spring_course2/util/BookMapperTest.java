package com.spring.homework2.spring_course2.util;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.BookDTO;
import com.spring.homework2.spring_course2.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {


    }

    @Test
    void mapBookToDTO() {

        Book book = new Book();
        book.setTitle("title");
        book.setAuthors("author");
        book.setGenre("genre");

        List<Comment>comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setComment("comment1");
        Comment comment2 = new Comment();
        comment2.setComment("comment2");

        comments.add(comment1);
        comments.add(comment2);

        book.setComments(comments);

        BookDTO bookDTO = BookMapper.mapBookToDTO(book);
        System.out.println(bookDTO);
    }
}