package com.github.seckill.entity.vo;

import com.github.seckill.constant.SeckillStateEnum;
import com.github.seckill.entity.seckill.SuccessKilled;
import lombok.Data;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
@Data
public class SeckillExecution {

    private long seckillId;

    private int state;

    private String stateInfo;

    private SuccessKilled successKilled;

    //秒杀成功
    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getInfo();
        this.successKilled = successKilled;
    }

    //秒杀失败
    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getInfo();
    }

    public SeckillExecution(long seckillId) {
        this.seckillId = seckillId;
    }
}
