package com.github.seckill.controller;

import com.github.seckill.entity.Instance;
import com.github.seckill.service.InstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/9
 */
@RestController
public class InstanceController {

    @Resource
    private InstanceService instanceService;


    @GetMapping("/instances")
    public List<Instance> queryInstanceList() {
        return instanceService.queryInstanceList();
    }


}
