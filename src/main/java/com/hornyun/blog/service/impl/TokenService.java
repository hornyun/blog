package com.hornyun.blog.service.impl;

import com.hornyun.blog.dto.UserDTO;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.IUserService;
import com.hornyun.blog.util.UUIDUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
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

    public String generateToken(User loginUser) {
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

    @Resource(name = "userServiceImpl")
    IUserService userService;



    public UserDTO authUser(User user) {
        User find = userService.queryByUsername(user.getUsername());
        if (find == null) {
            return null;
        }else{
            ByteSource credentialsSalt = ByteSource.Util.bytes(find.getSalt());
            String toCheckPassword = new SimpleHash("MD5", user.getPassword(), credentialsSalt, 1024).toHex();
            if (!toCheckPassword.equals(find.getPassword())) {
                return null;
            }else{
                String token = generateToken(find);
                UserDTO result = new UserDTO();
                BeanUtils.copyProperties(find, result);
                result.setToken(token);
                return result;
            }
        }
    }
}
