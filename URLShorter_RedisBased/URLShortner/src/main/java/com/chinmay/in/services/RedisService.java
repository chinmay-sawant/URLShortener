package com.chinmay.in.services;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String setValue(String longurl, String shorturl, long ttl) {
        redisTemplate.opsForValue().set(shorturl, longurl);
        redisTemplate.expire(shorturl, ttl, TimeUnit.SECONDS);
        return shorturl;
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}