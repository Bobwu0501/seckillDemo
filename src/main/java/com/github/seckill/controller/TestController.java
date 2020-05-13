package com.github.seckill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/4/30
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "service is ok.";
    }


}
