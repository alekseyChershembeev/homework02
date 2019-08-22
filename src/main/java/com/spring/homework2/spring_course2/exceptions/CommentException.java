package com.spring.homework2.spring_course2.exceptions;

/**
 * Created by Chershembeev_AE
 * Date: 22.08.2019
 * Time: 13:16.
 */
public class CommentException extends IllegalArgumentException {
    /**
     * Instantiates a new Comment exception.
     *
     * @param s the s
     */
    public CommentException(String s) {
        super("Comment not found from "+s);
    }
}
