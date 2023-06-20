package com.hornyun.blog.service;

import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    void testMatcher() {
        ByteSource credentialsSalt = ByteSource.Util.bytes("acf9ccc2a5637352");
        String md5 = new SimpleHash("MD5", "123456", credentialsSalt, 1024).toHex();
        System.out.println("md5 is "+ md5);
    }

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