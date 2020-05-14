package com.github.seckill.entity.vo;

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
    public SeckillExecution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }

    //秒杀失败
    public SeckillExecution(long seckillId, int state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public SeckillExecution(long seckillId) {
        this.seckillId = seckillId;
    }
}
