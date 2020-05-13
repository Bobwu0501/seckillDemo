package com.github.seckill.entity.vo;

import lombok.Data;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/13
 */
@Data
public class RestfulEntity<T> {

    private Boolean status;

    private String code;

    private T data;

    private String msg;

    public RestfulEntity(Boolean status, String code, T data, String msg) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> RestfulEntity<T> getSuccess(T data) {
        return new RestfulEntity<>(true, "success", data, "success");
    }

    public static <T> RestfulEntity<T> getFailure(String errorCode, String msg) {
        return new RestfulEntity<>(false, errorCode, null, msg);
    }

}
