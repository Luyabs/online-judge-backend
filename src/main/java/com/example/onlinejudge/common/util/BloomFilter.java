package com.example.onlinejudge.common.util;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BloomFilter {
    @Autowired
    private RedissonClient redisson;
    /**
     * 布隆过滤器初始化
     *
     * @param bloomFilterName 过滤器名称
     */
    public void bloomFilterInit(String bloomFilterName) {

        RBloomFilter<String> bloomFilter= redisson.getBloomFilter(bloomFilterName);
        //布隆过滤器计算的正确率为97%，初始化布隆过滤器容量为50000L
        bloomFilter.tryInit(500000L,0.03);
    }

    /**
     * 布隆过滤器添加数据
     *
     * @param bloomFilterName 过滤器名称
     * @param value           要添加的值
     */
    public boolean bloomFilterAdd(String bloomFilterName, String value) {
        RBloomFilter<Object> bloomFilter= redisson.getBloomFilter(bloomFilterName);
        return bloomFilter.add(value);
    }

    /**
     * 布隆过滤器数据统计
     *
     * @param bloomFilterName
     * @param value
     */
    public boolean bloomFilterContains(String bloomFilterName, String value){
        RBloomFilter<Object> bloomFilter= redisson.getBloomFilter(bloomFilterName);
        return bloomFilter.contains(value);
    }
}
