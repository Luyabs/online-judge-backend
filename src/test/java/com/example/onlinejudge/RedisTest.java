package com.example.onlinejudge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired(required = false)
    private RedisTemplate redisTemplate;


    @Test
    void getValue(){
        redisTemplate.opsForValue().set("test_redis","helloWorld!");
        System.out.println(redisTemplate.opsForValue().get("test_redis"));
    }
}
