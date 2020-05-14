package com.github.seckill.service;

import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.entity.vo.Exposer;
import com.github.seckill.entity.vo.SeckillExecution;

import java.util.List;

/**
 * @author bobwu
 * @Title: SeckillService
 * @ProjectName seckill
 * @date 2020-05-1322:19
 */
public interface SeckillService {

    List<Seckill> seckillList();

    Seckill getSeckillById(Long seckillId);

    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5);


}
