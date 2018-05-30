package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //这样标识后HelloWorld成为控制器，在springmvc叫做handler处理器或请求处理器
public class HelloWorld {
    /**
     * 1、使用@RequestMapping注解来映射请求的URL
     * 2、返回值会通过视图解析器解析为实际的物理视图:对于InternalResourceViewResolver视图解析器，会做如下解析：
     *    通过prefix+returnvel+后缀这样的方式得到实际的物理视图，然后转发
     *    /WEB-INF/pages/success.jsp
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("HelloWorld");
        return "success";
    }
}