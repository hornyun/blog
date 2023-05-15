package com.hornyun.blog.service;

import com.hornyun.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hornyun
 * created 2023 05 15
 */
@SpringBootTest
@Slf4j
class IUserServiceTest {
    @Resource
    private IUserService userService;

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername("hornyun");
        user.setActivated(1);
        user.setCreatedTime(LocalDateTime.now());
        user.setPassword("123456");
        user.setEmail("hornyun@sina.com");

        boolean save = userService.save(user);
        assertTrue(save);
        log.info("save output:{}", true);
    }
}