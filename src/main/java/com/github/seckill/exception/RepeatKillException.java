package com.github.seckill.exception;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
public class RepeatKillException extends RuntimeException {


    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
