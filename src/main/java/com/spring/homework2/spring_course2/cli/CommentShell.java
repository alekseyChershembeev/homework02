package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.service.CommentService;
import java.util.List;
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

    /**
     * Instantiates a new Comment shell.
     *
     * @param commentService the comment service
     */
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

    /**
     * Add new comment.
     *
     * @param bookId  the book id
     * @param comment the comment
     */
    @ShellMethod(value = "add new Comment", key = "add-comment")
    public void addNewComment(
            @ShellOption(help = "bookId") String bookId,
            @ShellOption(help = "comment") String comment) {
        long id;
        if (bookId.matches("\\d+")) {
            id = Long.parseLong(bookId);

            commentService
                    .create(new Comment(comment, id));
        }

    }

    /**
     * Gets comments.
     *
     * @param id the id
     * @return the comments
     */
    @ShellMethod(value = "show comments to Book", key = "show-comments")
    public String getComments(@ShellOption(help = "id book") int id) {
        List<Comment> comments = commentService.getByBookId(id);
        return comments.toString();
    }

    /**
     * Delete comment string.
     *
     * @param id the id
     * @return the string
     */
    @ShellMethod(value = "delete Comment by id", key = "delete-comment")
    public String deleteComment(@ShellOption(help = "id comment") String id) {
        final long longId = Long.parseLong(id);
        boolean isDelete = id.matches("\\d+");

        if (commentService
                .delete(longId)) {
            return "Comment was delete successfully";
        } else
            return "Comment doesn't exist";
    }


}
