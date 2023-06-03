package com.hornyun.blog.service;

import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class IUserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    void getUserById() {
        User user = userService.getById("1");
        log.info("get user by id is {}", user);
    }

    @Test
    void login() {
        User hornyun = userService.queryByUsername("hornyun");
        log.info("get user by username is {}", hornyun);
    }

    @Test
    void registerTest() {
        User user = userService.getById("1H1HDRBBP0000100007F0000BF901FD1");
        userService.removeById("1H1HDRBBP0000100007F0000BF901FD1");
        user.setPassword("123456");
        BlogResponse<User> register = userService.register(user);
        Assertions.assertNotNull(register);
    }


}