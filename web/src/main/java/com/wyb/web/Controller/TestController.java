package com.wyb.web.Controller;

import com.wyb.core.Service.Impl.TestAServiceImpl;
import com.wyb.core.Service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15019 on 2017/3/21.
 */
@Controller
public class TestController {
    /**
     * 注意添加依赖需要maven 重新打包
     */
    @Resource(name = "a")
    private TestService A; //测试多个接口实现
    private TestAServiceImpl B = new TestAServiceImpl();//直接类实现
    private TestService C = new TestAServiceImpl();//接口回调

    @RequestMapping("dependenceTest")
    public String test() {
        System.out.printf("1111111111111111111111111111111111111111 ");
        A.buildString();
        System.out.printf("1111111111111111111111111111111111111111");
        B.buildString();
        System.out.printf("1111111111111111111111111111111111111111");
        C.buildString();
        System.out.printf("1");
        return "400.jsp";
    }


    /**
     * Bean 工厂 ApplicationContext
     *
     * @param request
     */
    @RequestMapping(value = "application", method = RequestMethod.POST)
    public void app(HttpServletRequest request) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath*:spring-mybatis.xml");
        ac.getBean("dataSource");
        ac.getApplicationName();
        ac.getDisplayName();
        ac.getAutowireCapableBeanFactory();

//      ServletContext,是一个全局的储存信息的空间，服务器开始，其就存在，服务器关闭，其才释放。request，一个用户可有多个；session，一个用户一个；而servletContext，所有用户共用一个。
//      所以，为了节省空间，提高效率，ServletContext中，要放必须的、重要的、所有用户需要共享的线程又是安全的一些信息。
        ServletContext application = request.getServletContext();
        application.getInitParameter("contextConfigLocation");
        ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
        ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(application);
        ac1.getBean("beanId");
        ac2.getBean("beanId");
    }


}
