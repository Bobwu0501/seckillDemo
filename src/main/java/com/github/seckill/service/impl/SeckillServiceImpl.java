package com.github.seckill.service.impl;

import com.github.seckill.dao.SeckillMapper;
import com.github.seckill.dao.SuccessSeckilledMapper;
import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.entity.seckill.SuccessKilled;
import com.github.seckill.entity.vo.Exposer;
import com.github.seckill.entity.vo.SeckillExecution;
import com.github.seckill.exception.RepeatKillException;
import com.github.seckill.exception.SeckillClosedException;
import com.github.seckill.exception.SeckillException;
import com.github.seckill.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
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

    private final String salt = "iua$&*0ewi@1bv98adv_2";

    @Resource
    private SeckillMapper seckillMapper;

    @Resource
    private SuccessSeckilledMapper successSeckilledMapper;

    @Override
    public List<Seckill> seckillList() {
        List<Seckill> seckillList = seckillMapper.querySeckillList();
        return seckillList;
    }

    @Override
    public Seckill getSeckillById(Long seckillId) {
        Seckill seckill = null;
        try {
            seckill = seckillMapper.getSeckillById(seckillId);
        } catch (Exception e) {
            return null;
        }
        return seckill;
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill = getSeckillById(seckillId);
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();

        Date now = new Date();
        //秒杀没有开启
        if (startTime.getTime() > now.getTime() || endTime.getTime() < now.getTime()) {
            return new Exposer(false, seckillId, startTime.getTime(), now.getTime(), endTime.getTime());
        }
        String md5 = getMd5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException {

        //校验md5
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }

        //执行秒杀逻辑: 减库存+增加购买明细
        Date now = new Date();
        try {
            //增加购买明细
            int insertCount = successSeckilledMapper.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                throw new RepeatKillException("seckill repeated");
            } else {
                //减库存
                int updateCount = seckillMapper.reduceProductNumber(seckillId, now);
                if (updateCount <= 0) {
                    throw new SeckillClosedException("seckill closed");
                } else {
                    //秒杀成功，得到成功插入明细记录，并返回成功秒杀的信息
                    SuccessKilled successKilled = successSeckilledMapper.querySuccessKilledByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, successKilled.getState(), "success", successKilled);
                }

            }


        }


        return null;
    }

    private String getMd5(long seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


}
