package com.github.seckill.exception;

import lombok.Getter;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/15
 */
@Getter
public enum  SeckillErrorCode {
    USERPHONE_ERROR("S0001","userphone.error");

    private String errorCode;

    private String message;

    SeckillErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
