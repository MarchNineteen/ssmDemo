package com.wyb.web.Config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 *
 * @author wyb
 * @date 2017/4/11
 * 容易初始化要执行的类  要继承的接口
 */
public class Init implements InitializingBean, ServletContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
    /**
     * servlet 容器初始化
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {

    }

    /**
     *  自定义初始化
     */
    private void init() {

    }
}
