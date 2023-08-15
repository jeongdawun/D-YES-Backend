package com.dyes.backend.utility.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{
    final private RedisTemplate<String, String> redisTemplateObject;

    @Override
    public void setUserTokenAndUser (String UUID, String userId) {
        ValueOperations<String, String> value = redisTemplateObject.opsForValue();
        value.set(UUID, userId, Duration.ofHours(1));
    }

}
