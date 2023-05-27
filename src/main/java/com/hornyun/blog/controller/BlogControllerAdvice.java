package com.hornyun.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornyun.blog.enums.BlogExceptionEnum;
import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.exception.BlogBaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hornyun
 */
@ControllerAdvice
@Slf4j
public class BlogControllerAdvice {
    @Resource
    private ObjectMapper objectMapper;


    @ExceptionHandler(value = BlogBaseException.class)
    public String blogExceptionHandler(HttpServletResponse response, BlogBaseException exception) {
        log.error("blog system occur error", exception);
        return errorHandler(response, exception.getBlogMessage(), HttpServletResponse.SC_OK);
    }

    @ExceptionHandler(value = ShiroException.class)
    public String shiroExceptionHandler(HttpServletResponse response, ShiroException e) {
        log.error("access blog e", e);
        return errorHandler(response, BlogExceptionEnum.SHIRO_EXCEPTION, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeExceptionHandle(HttpServletResponse response, RuntimeException e) {
        log.error("blog system occur runtime exception", e);
        return errorHandler(response, BlogExceptionEnum.SERVER_ERROR_EXCEPTION, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }



    private String errorHandler(HttpServletResponse response, BlogExceptionEnum message, int status){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(BlogResponse.failure(message.getMessage())));
        } catch (IOException ex) {
            log.error("controller advice occur IO error", ex);
            throw new BlogBaseException(BlogExceptionEnum.SHIRO_EXCEPTION);
        }
        out.flush();
        return "";
    }
}
