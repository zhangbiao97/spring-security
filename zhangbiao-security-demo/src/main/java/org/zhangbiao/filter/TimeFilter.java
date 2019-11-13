package org.zhangbiao.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 22:43
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter doFilter......");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("TimeFilter 耗时：" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy......");
    }
}
