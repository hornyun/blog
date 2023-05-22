package com.hornyun.blog.exception;

/**
 * @author hornyun
 * created on 2023/05/21
 */
public class BlogBaseException extends RuntimeException {
    public BlogBaseException() {
    }

    public BlogBaseException(String message) {
        super(message);
    }
    public BlogBaseException(Exception exception) {
        super(exception);
    }
}
