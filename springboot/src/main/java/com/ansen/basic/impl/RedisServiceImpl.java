package com.ansen.service.impl;

import com.ansen.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * @Desc 存储数据
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * @Desc 获取数据
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
       return redisTemplate.opsForValue().get(key);
    }

    /**
     * @Desc 删除数据
     * @param key
     */
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * @Desc 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(String key, long expire) {
        return  redisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    /**
     * @Desc 自增操作
     * @param key
     * @param delta
     * @return
     */
    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key,delta);
    }
}
