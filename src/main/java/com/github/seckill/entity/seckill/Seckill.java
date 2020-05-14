package com.github.seckill.entity.seckill;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;


/**
 * @author bobwu
 * @Title: Seckill
 * @ProjectName seckill
 * @date 2020-05-1322:37
 */
@Data
@Alias("seckill")
public class Seckill {

    private Long seckillId;

    private String name;

    private Long number;

    private Date startTime;

    private Date endTime;

    private Date createTime;
}
