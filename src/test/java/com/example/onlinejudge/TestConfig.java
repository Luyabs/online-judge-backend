package com.example.onlinejudge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import javax.annotation.PostConstruct;

@Configuration
public class TestConfig {

    @Autowired
    CacheManager cacheManager;

    @PostConstruct
    public void viewDefaultCacheManager() {
        RedisCacheManager redisCacheManager = (RedisCacheManager) this.cacheManager;
        System.out.println(redisCacheManager);
    }
}

