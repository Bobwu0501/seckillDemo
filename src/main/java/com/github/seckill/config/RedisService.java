package com.github.seckill.config;

import java.util.Optional;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/15
 */
public interface RedisService {

    /**
     * 获取缓存值
     *
     * @param key
     * @return
     */
    Optional<Object> get(String key);


}
