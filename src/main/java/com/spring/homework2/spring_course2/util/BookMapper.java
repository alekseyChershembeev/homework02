package com.spring.homework2.spring_course2.util;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.rest.BookDTO;
import com.spring.homework2.spring_course2.rest.CommentDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by Chershembeev_AE
 * Date: 17.09.2019
 * Time: 16:55.
 */

public class BookMapper {

    public static BookDTO mapBookToDTO(Book book) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthors(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        if (book.getComments() != null) {
            List<CommentDTO>listCommentDTO = new ArrayList<>();
            book.getComments().forEach(c->{
                CommentDTO commentDTO =new CommentDTO();
                commentDTO.setComment(c.getComment());
            });

            bookDTO.setComments(listCommentDTO);
        } else {
            bookDTO.setComments(null);
        }


        return bookDTO;
    }

    public static List<BookDTO> mapBookListToDTO(List<Book> books) {
        return books
                .stream()
                .map(BookMapper::mapBookToDTO)
                .collect(Collectors.toList());
    }

    public static CommentDTO mapCommentToDTO(Comment comment) {
        CommentDTO result = new CommentDTO();
        result.setComment(comment.getComment());
        return result;
    }
}
