package com.wyb.web.servlet;

import com.wyb.web.config.Init;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wyb
 */
public class CustomServlet extends HttpServlet {

    @Resource
    Init init;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CustomServlet INIT");
    }
}
