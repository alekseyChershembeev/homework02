package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.dao.BookDAO;
import com.spring.homework2.spring_course2.dao.CommentDAO;
import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */

@ShellComponent
public class CommentShell {

    private CommentService commentService;

    public CommentShell(CommentService commentService) {
        this.commentService = commentService;
    }

    //    private CommentDAO commentDAO;
//
//    private BookDAO bookDAO;
//
//    @Autowired
//    public CommentShell(CommentDAO commentDAO, BookDAO bookDAO) {
//        this.commentDAO = commentDAO;
//        this.bookDAO = bookDAO;
//    }

    @ShellMethod(value = "add new Comment", key = "add-comment")
    public void addNewComment(
            @ShellOption(help = "bookId") String bookId,
            @ShellOption(help = "comment") String comment) {
        long id = 0;
        if (bookId.matches("\\d+")) {
            id = Long.parseLong(bookId);

            commentService
                    .create(new Comment(comment, id));
        }

    }

    @ShellMethod(value = "show comments to Book", key = "show-comments")
    public String getComments(@ShellOption(help = "id book") int id) {
        List<Comment> comments = commentService.getByBookId(id);
        return comments.toString();
    }

    @ShellMethod(value = "delete Comment by id", key = "delete-comment")
    public String deleteComment(@ShellOption(help = "id comment") String id) {
        final long longId = Long.parseLong(id);

        boolean isDelete = id.matches("\\d+");


        if (isDelete) {
            commentService
                    .delete(longId);
            return "Comment was delete successfully";
        } else
            return "Comment doesn't exist";
    }


}
