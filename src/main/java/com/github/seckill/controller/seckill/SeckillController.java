package com.github.seckill.controller.seckill;

import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.entity.vo.Exposer;
import com.github.seckill.entity.vo.RestfulEntity;
import com.github.seckill.service.SeckillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @GetMapping()
    public RestfulEntity<List> seckillList() {
        List<Seckill> seckillList = seckillService.seckillList();
        return RestfulEntity.getSuccess(seckillList);
    }

    @GetMapping("/{seckillId}")
    public RestfulEntity<Seckill> getSeckillById(@PathVariable("seckillId") long seckillId) {
        Seckill seckill = seckillService.getSeckillById(seckillId);
        return RestfulEntity.getSuccess(seckill);
    }

    @GetMapping("/{seckillId}/exposer")
    public RestfulEntity<Exposer> exposer(@PathVariable("seckillId") long seckillId) {
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        return RestfulEntity.getSuccess(exposer);
    }


}
