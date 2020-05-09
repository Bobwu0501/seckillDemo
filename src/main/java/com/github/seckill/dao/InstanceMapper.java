package com.github.seckill.dao;


import com.github.seckill.entity.Instance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/9
 */
@Mapper
public interface InstanceMapper {

    /**
     * 获取实例列表信息
     *
     * @return Instance列表
     */
    List<Instance> queryInstanceList();


}
