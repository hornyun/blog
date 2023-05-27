package com.hornyun.blog.controller;

import com.hornyun.blog.dto.BlogResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login/test")
    @ResponseBody
    public BlogResponse<String> test() {
        return BlogResponse.success("test");
    }
}
