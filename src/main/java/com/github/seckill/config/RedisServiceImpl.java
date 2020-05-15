package com.github.seckill.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/15
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public Optional<Object> get(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("redisKey参数为空");
            throw new NullPointerException("redisKey参数为空");
        }
        Object value = redisTemplate.opsForValue().get(key);
        log.info("获取缓存，key：{}，value：{}", key, value);
        return Optional.ofNullable(value);
    }

    @Override
    public Boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
