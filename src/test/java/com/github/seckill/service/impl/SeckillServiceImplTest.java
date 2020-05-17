package com.github.seckill.service.impl;

import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.service.SeckillService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
class SeckillServiceImplTest {

    @Resource
    private SeckillService seckillService;

    @Test
    void getSeckillById() {
        Long id = 1000L;
        Seckill seckillById = seckillService.getSeckillById(id);
        System.out.println(seckillById.getName());
    }
}