package com.wyb.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wyb
 */
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
