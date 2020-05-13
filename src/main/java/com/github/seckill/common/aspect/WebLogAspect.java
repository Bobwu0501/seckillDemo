package com.github.seckill.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/13
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.github.seckill.controller..*.*(..))")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("===== URL : " + request.getRequestURI());
        log.info("===== IP  : " + request.getRemoteAddr());
    }


    @AfterReturning(returning = "res", pointcut = "pointCut()")
    public void afterReturning(Object res) throws Throwable {
        //处理完成后，打印日志
        log.info("===== RESPONSE : " + res.toString());

    }


}
