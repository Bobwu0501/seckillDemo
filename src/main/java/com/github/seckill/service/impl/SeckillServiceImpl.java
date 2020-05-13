package com.github.seckill.service.impl;

import com.github.seckill.dao.SeckillMapper;
import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobwu
 * @Title: SeckillServiceImpl
 * @ProjectName seckill
 * @date 2020-05-1322:54
 */
@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {


    @Resource
    private SeckillMapper seckillMapper;


    @Override
    public List<Seckill> seckillList() {
        List<Seckill> seckillList = seckillMapper.querySeckillList();
        return seckillList;
    }
}
