package com.wyb.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wyb
 */
public class CustomListener2 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener22 init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
