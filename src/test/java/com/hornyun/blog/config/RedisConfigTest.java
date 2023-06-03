package com.hornyun.blog.config;

import com.hornyun.blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class RedisConfigTest {
    @Resource(name = "redisTemplate1")
    RedisTemplate<String, Object> redisTemplate;
    @Resource
    private IUserService userService;

    @Test
    void testGet() {
        redisTemplate.opsForValue().set("hornyun", userService.queryByUsername("hornyun"));
        Object o = redisTemplate.opsForValue().get("hornyun");
        log.info("get key=hornyun1 value is {}", o);
    }
}