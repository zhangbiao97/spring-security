package org.zhangbiao.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 23:20
 */
@Component
@Aspect
public class TimeAspect {

    @Around("execution(* org.zhangbiao.web.controller.UserController.*(..))")
    public Object handleUserControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("TimeAspect start");
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("TimeAspect 耗时："+(endTime-startTime));
        System.out.println("TimeAspect end");
        return result;
    }


}
