package com.spring.homework2.spring_course2.repository;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.entity.Genre;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CommentDaoImplTest {

    @Autowired
    TestEntityManager em;
    @Autowired
    private CommentRepository commentRepository;

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

        comment = new Comment();
        comment.setBook(book);
        comment.setCommentText("Bad comment");

    }

    @Test
    public void create() {

        Comment comment2 = commentRepository.save(comment);
        assertThat(comment2)
                .hasFieldOrPropertyWithValue("commentId", comment2.getCommentId())
                .hasFieldOrPropertyWithValue("commentText", "Bad comment")
                .hasFieldOrPropertyWithValue("book.bookId", comment2.getBook().getBookId())
                .hasNoNullFieldsOrProperties();
    }

    @Test
    public void getCommentByBookId() {
        Comment comment2 = commentRepository.save(comment);
        List<Comment> comments = commentRepository.findByBookBookIdIs(comment2.getBook().getBookId());

        assertThat(comments.get(0))
                .hasFieldOrPropertyWithValue("commentId", comment2.getCommentId())
                .hasFieldOrPropertyWithValue("commentText", "Bad comment")
                .hasFieldOrPropertyWithValue("book.bookId", comment2.getBook().getBookId())
                .hasNoNullFieldsOrProperties();
    }

    @Test
    public void delete() {
        Comment comment2 = commentRepository.save(comment);
        System.out.println(commentRepository.deleteCommentByCommentId(comment2.getCommentId()));


    }
}