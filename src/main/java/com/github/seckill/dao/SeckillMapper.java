package com.github.seckill.dao;

import com.github.seckill.entity.seckill.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bobwu
 * @Title: SeckillMapper
 * @ProjectName seckill
 * @date 2020-05-1322:19
 */
@Mapper
public interface SeckillMapper {

    List<Seckill> querySeckillList();





}
