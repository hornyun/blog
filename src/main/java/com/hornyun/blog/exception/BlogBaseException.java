package com.hornyun.blog.exception;

import com.hornyun.blog.enums.BlogExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hornyun
 * created on 2023/05/21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogBaseException extends RuntimeException {

    @SuppressWarnings("all")
    private BlogExceptionEnum blogMessage;

    public BlogBaseException(BlogExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.blogMessage = exceptionEnum;
    }

    public BlogBaseException(Exception e) {
        super(e);
    }
}
