package com.spring.homework2.spring_course2.service;

import com.spring.homework2.spring_course2.repository.CommentRepository;
import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.entity.Genre;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Import(CommentServiceImpl.class)
public class CommentServiceImplTest {

    @Autowired
    CommentService commentService;

    @MockBean
    CommentRepository commentRepository;

    private Book book;
    private Author author;
    private Genre genre;
    private Comment comment;

    @Before
    void setUp() throws Exception {

        book = new Book();
        author = new Author();
        author.setAuthorName("Author");
        author.setAuthorLastName("AuthorLastName");

        genre = new Genre();
        genre.setGenreName("Genre");

        book.setBookName("Book");
        book.setBookAuthor(author);
        book.setBookGenre(genre);

        comment = new Comment();
        comment.setBook(book);
        comment.setCommentText("Bad comment");
    }

    @Test
    void create() {
        commentService.create("newComment",1L);
    }

    @Test
    void getByBookId() {
        commentService.getByBookId(1L);
    }

    @Test
    void delete() {
        commentService.delete(1L);
    }
}