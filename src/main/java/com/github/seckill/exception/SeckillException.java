package com.github.seckill.exception;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
