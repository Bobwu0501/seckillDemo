package com.github.seckill.entity.seckill;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/14
 */
@Data
@Alias("successKilled")
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    private Seckill seckill;

}
