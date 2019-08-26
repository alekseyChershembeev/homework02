package com.spring.homework2.spring_course2.dao;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@Import(CommentDaoImpl.class)
@Transactional
public class CommentDaoImplTest {

    @Autowired
    private CommentDAO commentDAO;




    private Book book;
    private Author author;
    private Genre genre;
    private Comment comment;

    @Before
    public void setUp() {
        book = new Book();
        author = new Author();
        author.setAuthorName("Author");
        author.setAuthorLastName("AuthorLastName");

        genre = new Genre();
        genre.setGenreName("Genre");

        book.setBookName("Book");
        book.setBookAuthor(author);
        book.setBookGenre(genre);
//        book.setBookId(1L);

        comment = new Comment();
        comment.setBook(book);
        comment.setCommentText("Bad comment");

    }

    @Test
    public void create() {

        commentDAO.create(comment);
        List<Comment> comments = commentDAO.getCommentsByBookId(1L);
        assertThat(comments.get(0))
                .hasFieldOrPropertyWithValue("commentId", 1L)
                .hasFieldOrPropertyWithValue("commentText", "Bad comment")
                .hasFieldOrPropertyWithValue("book.bookId", 1L)
                .hasNoNullFieldsOrProperties();
        System.out.println(comments);
    }

    @Test
    public void getByBookId() {
        commentDAO.create(comment);
        System.out.println(commentDAO.getCommentsByBookId(1L));
    }

    @Test
    public void delete() {
        commentDAO.create(comment);
        System.out.println(commentDAO.getCommentsByBookId(1L));
        commentDAO.delete(1L);


    }
}