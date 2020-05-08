package com.github.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/4/30
 */
@Controller
public class TestController {


    @GetMapping("/test")
    public String test(){
        return "service is ok.";
    }





}
