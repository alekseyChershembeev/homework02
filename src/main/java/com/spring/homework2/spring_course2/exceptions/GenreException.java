package com.spring.homework2.spring_course2.exceptions;

/**
 * Created by Chershembeev_AE
 * Date: 22.08.2019
 * Time: 13:16.
 */
public class GenreException extends IllegalArgumentException {
    /**
     * Instantiates a new Genre exception.
     *
     * @param message the message
     */
    public GenreException(String message) {
        super("Author not found froms " + message);
    }
}
