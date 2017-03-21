package com.wyb.web.Controller;

import com.wyb.core.Service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 15019 on 2017/3/21.
 */
@Controller
public class TestController {
    @Resource(name = "a")
    private TestService A; //测试多个接口实现

    @RequestMapping("test")
    public String test(){
        A.buildString();
        return "";
    }
}
