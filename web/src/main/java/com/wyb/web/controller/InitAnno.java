package com.wyb.web.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author wyb
 */
@Component
public class InitAnno implements InitializingBean, ServletContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitAnno");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
