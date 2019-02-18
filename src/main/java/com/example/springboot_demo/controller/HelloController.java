package com.example.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebResult;
import java.util.Map;

@Controller
public class HelloController {

/*
    @RequestMapping({"/","/index.html"})
    public  String index(){
        return "login";
    }
*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @WebResult
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }
}
