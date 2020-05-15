package com.github.seckill.controller;

import com.github.seckill.config.RedisConfig;
import com.github.seckill.config.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/4/30
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private RedisService redisService;


    @GetMapping("/test")
    public String test() {
        Optional<Object> wsy = redisService.get("wsy");
        String value = wsy.get().toString();
        System.out.println(value);
        return "service is ok.";
    }


}
