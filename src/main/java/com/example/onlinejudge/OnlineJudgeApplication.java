package com.example.onlinejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class OnlineJudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineJudgeApplication.class, args);
    }

}
