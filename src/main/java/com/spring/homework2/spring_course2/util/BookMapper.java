package com.spring.homework2.spring_course2.util;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.rest.BookDTO;
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
        bookDTO.setAuthors(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        if (book.getComments() != null) {
            bookDTO.setComments(book.getComments().toString());
        } else {
            bookDTO.setComments("");
        }


        return bookDTO;
    }

    public static List<BookDTO> mapBookListToDTO(List<Book> books) {
        return books
                .stream()
                .map(BookMapper::mapBookToDTO)
                .collect(Collectors.toList());
    }
}
