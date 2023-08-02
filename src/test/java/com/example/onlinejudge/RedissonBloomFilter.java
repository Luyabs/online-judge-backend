package com.example.onlinejudge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedissonBloomFilter {
    @Resource(name = "redissonClient")
    private RedissonClient redissonClient;

    @Test
    public void bloomFilterDemo(){
        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("bloom-filter");
        //初始化，容器10000.容错率千分之一
        bloomFilter.tryInit(10000,0.001);
        //添加10000个
        for (int i = 0; i < 10000; i++) {
            bloomFilter.add("ly" + i);
        }
        //用来统计误判的个数
        int count = 0;
        //查询不存在的数据一千次
        for (int i = 0; i < 1000; i++) {
            if (bloomFilter.contains("ljj" + i)) {
                count++;
            }
        }
        System.out.println("判断错误的个数："+count);
        System.out.println("ly9999是否在过滤器中存在："+bloomFilter.contains("ly9999"));
        System.out.println("ljj11111是否在过滤器中存在："+bloomFilter.contains("ljj11111"));
        System.out.println("预计插入数量：" + bloomFilter.getExpectedInsertions());
        System.out.println("容错率：" + bloomFilter.getFalseProbability());
        System.out.println("hash函数的个数：" + bloomFilter.getHashIterations());
        System.out.println("插入对象的个数：" + bloomFilter.count());
    }
}


