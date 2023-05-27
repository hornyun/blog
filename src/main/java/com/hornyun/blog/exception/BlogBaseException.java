package com.hornyun.blog.exception;

import com.hornyun.blog.enums.BlogExceptionEnum;
import lombok.Data;

/**
 * @author hornyun
 * created on 2023/05/21
 */
@Data
public class BlogBaseException extends RuntimeException {

    @SuppressWarnings("all")
    private BlogExceptionEnum blogMessage;

    public BlogBaseException(BlogExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.blogMessage = exceptionEnum;
    }
}
