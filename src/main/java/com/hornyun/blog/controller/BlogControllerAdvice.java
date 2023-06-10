package com.hornyun.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.enums.BlogExceptionEnum;
import com.hornyun.blog.exception.BlogBaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    public void blogExceptionHandler(HttpServletResponse response, BlogBaseException exception) throws IOException {
        log.error("blog system occur error", exception);
        errorHandler(response, exception.getBlogMessage(), HttpServletResponse.SC_OK);
    }

    @ExceptionHandler(AuthorizationException.class)
    public void handleException(HttpServletResponse response, AuthorizationException e, Model model) throws IOException {
        log.error("AuthorizationException was thrown", e);
        errorHandler(response, BlogExceptionEnum.SHIRO_EXCEPTION, HttpServletResponse.SC_UNAUTHORIZED);
    }

    @ExceptionHandler(value = ShiroException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void shiroExceptionHandler(HttpServletResponse response, ShiroException e) throws IOException {
        log.error("access blog e", e);
        errorHandler(response, BlogExceptionEnum.SHIRO_EXCEPTION, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public void runtimeExceptionHandle(HttpServletResponse response, RuntimeException e) throws IOException {
        log.error("blog system occur runtime exception", e);
        errorHandler(response, BlogExceptionEnum.SERVER_ERROR_EXCEPTION, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }


    private void errorHandler(HttpServletResponse response, BlogExceptionEnum message, int status) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        PrintWriter out = response.getWriter();
        out.println(objectMapper.writeValueAsString(BlogResponse.failure(message.getMessage())));
        out.flush();
        out.close();
    }
}
