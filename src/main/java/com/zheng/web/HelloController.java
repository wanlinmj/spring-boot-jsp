package com.zheng.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * jsp页面控制器
 * Created by zhenglian on 2016/9/20.
 */
@Controller
public class HelloController {

    @Value("${application.hello:Hello World}")
    private String hello;

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        System.out.println("use jsp template...");
        map.put("hello", hello);

        return "hello";

    }

}
