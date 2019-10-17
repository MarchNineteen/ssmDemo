package com.wyb.web.config;

import com.wyb.core.service.TestService;
import com.wyb.web.controller.InitAnno;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 *
 * @author wyb
 * @date 2017/4/11
 * 容易初始化要执行的类  要继承的接口
 */
public class Init implements InitializingBean, ServletContextAware {

    @Resource(name = "a")
    TestService testService;
//    @Resource
//    InitAnno initAnno;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(testService.buildString());
//        System.out.println(initAnno.toString());
        System.out.println("InitializingBean");
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
