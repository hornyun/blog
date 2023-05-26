package com.hornyun.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.exception.BlogBaseException;
import lombok.extern.slf4j.Slf4j;
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
        return errorHandler(response, exception, HttpServletResponse.SC_OK);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeExceptionHandle(HttpServletResponse response, RuntimeException e) {
        log.error("blog system occur runtime exception", e);
        return errorHandler(response, new RuntimeException("服务异常，请联系管理员！"), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    private String errorHandler(HttpServletResponse response, RuntimeException e, int status){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(BlogResponse.failure(e.getMessage())));
        } catch (IOException ex) {
            log.error("controller advice occur IO error", e);
            throw new BlogBaseException("IO Exception" + e);
        }
        out.flush();
        return "";
    }
}
