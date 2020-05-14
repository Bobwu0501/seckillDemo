package com.github.seckill.constant;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功")

    ;

    private int state;

    private String info;


    SeckillStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }



}
