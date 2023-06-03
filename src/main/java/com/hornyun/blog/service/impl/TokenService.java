package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.User;
import com.hornyun.blog.util.UUIDUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hornyun
 */
@Service
public class TokenService {

    @Resource(name ="redisTemplate1")
    RedisTemplate<String,Object> redisTemplate;

    public String getToken(User loginUser) {
        String token = UUIDUtils.generate();
        redisTemplate.opsForValue().set(token, loginUser, 30, TimeUnit.MINUTES);
        return token;
    }

    public boolean checkToken(String token){
        User user = (User) redisTemplate.opsForValue().get(token);
        return user != null;
    }

    public User getUserByToken(String token) {
        return (User) redisTemplate.opsForValue().get(token);
    }

    public void refreshToken(String token) {
        redisTemplate.opsForValue().getAndExpire(token, 30, TimeUnit.MINUTES);
    }
}
