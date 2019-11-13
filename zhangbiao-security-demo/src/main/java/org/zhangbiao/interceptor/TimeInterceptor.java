package org.zhangbiao.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 22:53
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("TimeInterceptor preHandle......");
        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor postHandle......");
        long endTime = System.currentTimeMillis();
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("TimeInterceptor postHandle 耗时：" + (endTime - startTime));

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("exception is " + e);
    }
}
