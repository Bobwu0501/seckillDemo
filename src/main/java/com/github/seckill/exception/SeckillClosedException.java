package com.github.seckill.exception;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
public class SeckillClosedException extends RuntimeException {

    public SeckillClosedException(String message) {
        super(message);
    }

    public SeckillClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
