package com.wyb.web.filter;

import com.wyb.web.config.Init;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author wyb
 */
public class CustomFilter implements Filter {

    @Resource
    Init init;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
