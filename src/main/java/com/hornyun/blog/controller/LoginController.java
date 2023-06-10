package com.hornyun.blog.controller;

import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.impl.TokenService;
import com.hornyun.blog.shiro.BlogToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hornyun
 */
@RestController
public class LoginController {

    @GetMapping("/login/test")
    @ResponseBody
    public BlogResponse<String> test() {
        return BlogResponse.success("test");
    }

    @RequestMapping("/login/failure")
    @ResponseBody
    public BlogResponse<String> failure() {
        return BlogResponse.failure("没有权限");
    }

    @PostMapping("/login")
    @ResponseBody
    public BlogResponse<String> login(User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        return BlogResponse.success("test");
    }

    @Resource
    TokenService tokenService;

    @PostMapping("/login/token")
    @ResponseBody
    public BlogResponse<String> getToken(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        if (subject.isAuthenticated()) {
            String token = tokenService.getToken((User) subject.getPrincipal());
            subject.login(new BlogToken(token));
            return BlogResponse.success(token);
        }
        return BlogResponse.failure(null);
    }
}
