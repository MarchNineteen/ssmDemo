package com.wyb.web.listener;

import com.wyb.web.config.Init;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wyb
 */
public class CustomListener implements ServletContextListener {

//    @Resource
//    Init init;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
