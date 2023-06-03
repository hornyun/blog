package com.hornyun.blog.util;


import com.hornyun.blog.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringContextUtilTest {
    @Test
    void getBean() {
        UserServiceImpl userService = SpringContextUtil.getBean("userServiceImpl");
        log.info("get User service is {}", userService);
    }
}