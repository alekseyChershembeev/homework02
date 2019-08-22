package com.spring.homework2.spring_course2.exceptions;

/**
 * Created by Chershembeev_AE
 * Date: 22.08.2019
 * Time: 12:46.
 */
public class BookException extends IllegalArgumentException {

    /**
     * Instantiates a new Book exception.
     *
     * @param message the message
     */
    public BookException(String message) {
        super("Book not found from "+ message);
    }

}
