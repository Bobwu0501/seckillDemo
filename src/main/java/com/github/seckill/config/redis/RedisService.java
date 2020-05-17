package com.github.seckill.config.redis;

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


    /**
     * set缓存值
     *
     * @param key
     * @param value
     * @return
     */
    void set(String key, Object value);


    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    Boolean existsKey(String key);


}
