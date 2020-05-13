package com.github.seckill.controller.seckill;

import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.entity.vo.RestfulEntity;
import com.github.seckill.service.SeckillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobwu
 * @Title: SeckillController
 * @ProjectName seckill
 * @date 2020-05-1322:17
 */
@RestController
public class SeckillController {

    @Resource
    private SeckillService seckillService;


    @GetMapping("/seckill")
    public RestfulEntity<List> seckillList() {
        List<Seckill> seckillList = seckillService.seckillList();
        return RestfulEntity.getSuccess(seckillList);
    }


}
