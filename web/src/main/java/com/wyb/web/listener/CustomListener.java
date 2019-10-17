package com.wyb.web.listener;

import com.wyb.web.config.Init;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
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
//        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
//        Init init = (Init) springContext.getBean("init");
//
//        System.out.println(init);
        System.out.println("listener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
