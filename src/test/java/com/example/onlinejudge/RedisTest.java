package com.example.onlinejudge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.apache.naming.SelectorContext.prefix;


@SpringBootTest
public class RedisTest {
    @Autowired(required = false)
    private RedisTemplate<String, String> redisTemplate;


    @Test
    void getValue(){
        //新增键值对，ttl为1min
        redisTemplate.opsForValue().set("test_redis","helloWorld!",1, TimeUnit.MINUTES);
        //取键对应的值
        System.out.println(redisTemplate.opsForValue().get("test_redis"));
        //查询所有以"'problem:'"为前缀的key
        Set<String> keys = redisTemplate.keys("'problem:'" + '*');
        assert keys != null;
        System.out.println(keys.toString());

    }
}
