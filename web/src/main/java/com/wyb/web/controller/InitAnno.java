package com.wyb.web.controller;

import com.wyb.web.config.Init;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @author wyb
 */
@Component
public class InitAnno implements InitializingBean, ServletContextAware {

    @Resource
    Init init;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(init.toString());
        System.out.println("InitAnno  init");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
