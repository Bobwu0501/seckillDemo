package com.github.seckill.dao;

import com.github.seckill.entity.seckill.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author bobwu
 * @Title: SuccessSeckilledMapper
 * @ProjectName seckill
 * @date 2020-05-1409:34
 */
@Mapper
public interface SuccessSeckilledMapper {

    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    SuccessKilled querySuccessKilledByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
