package com.github.seckill.controller.seckill;

import com.github.seckill.constant.SeckillStateEnum;
import com.github.seckill.entity.seckill.Seckill;
import com.github.seckill.entity.vo.Exposer;
import com.github.seckill.entity.vo.RestfulEntity;
import com.github.seckill.entity.vo.SeckillExecution;
import com.github.seckill.exception.RepeatKillException;
import com.github.seckill.exception.SeckillClosedException;
import com.github.seckill.exception.SeckillErrorCode;
import com.github.seckill.service.SeckillService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{seckillId}/{md5}/execution")
    public RestfulEntity<SeckillExecution> execute(@PathVariable("seckillId") long seckillId, @PathVariable("md5") String md5,
                                                   @CookieValue(value = "userPhone", required = false) Long userPhone) {
        if (userPhone == null) {
            return RestfulEntity.getFailure(SeckillErrorCode.USERPHONE_ERROR.getErrorCode(), SeckillErrorCode.USERPHONE_ERROR.getMessage());
        }
        SeckillExecution seckillExecution = null;

        try {
            seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return RestfulEntity.getSuccess(seckillExecution);
        }catch (RepeatKillException e1){
            seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.REPEAR_KILL);
            return RestfulEntity.getSuccess(seckillExecution);
        }catch (SeckillClosedException e2){
            seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.END);
            return RestfulEntity.getSuccess(seckillExecution);
        } catch (Exception e3){
            seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
            return RestfulEntity.getSuccess(seckillExecution);
        }
    }
}
