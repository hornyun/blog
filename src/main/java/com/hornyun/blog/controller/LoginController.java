package com.hornyun.blog.controller;

import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

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
    public BlogResponse<User> login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        return BlogResponse.success((User) SecurityUtils.getSubject().getPrincipal());
    }

    @GetMapping("/login/user")
    public BlogResponse<User> getUser() {
        return BlogResponse.success((User) SecurityUtils.getSubject().getPrincipal());
    }

}
