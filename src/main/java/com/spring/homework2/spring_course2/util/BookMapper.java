package com.spring.homework2.spring_course2.util;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.BookDTO;
//import com.spring.homework2.spring_course2.rest.CommentDTO;
import com.spring.homework2.spring_course2.entity.Comment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setGenre(book.getGenre());

        Comment[] commentsArr = null;
        if (book.getComments() != null) {
            commentsArr = book.getComments().stream().toArray(Comment[]::new);
        }
        bookDTO.setComments(commentsArr);
        if (bookDTO.getComments() == null) {
            bookDTO.setComments(new Comment[]{});
        }

        return bookDTO;
    }

    public static Book bookDTOtoBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthors(bookDTO.getAuthors());
        book.setGenre(bookDTO.getGenre());

        List<Comment> commentList = new ArrayList<>(Arrays.asList(bookDTO.getComments()));
        book.setComments(commentList);

        return book;
    }

    public static List<BookDTO> mapBookListToDTO(List<Book> books) {
        return books
                .stream()
                .map(BookMapper::mapBookToDTO)
                .collect(Collectors.toList());
    }


}
