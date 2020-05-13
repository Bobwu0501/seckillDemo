package com.github.seckill.service.impl;

import com.github.seckill.dao.InstanceMapper;
import com.github.seckill.entity.Instance;
import com.github.seckill.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/9
 */
@Slf4j
@Service
public class InstanceServiceImpl implements InstanceService {

    @Resource
    private InstanceMapper instanceMapper;

    @Override
    public List<Instance> queryInstanceList() {
        return instanceMapper.queryInstanceList();
    }
}
