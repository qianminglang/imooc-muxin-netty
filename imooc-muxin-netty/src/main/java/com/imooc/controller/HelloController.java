package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: hello
 * @author: qml
 * @create: 2019-07-06 23:23
 */
@RestController
public class HelloController {
    @GetMapping("hello/controller")
    public String hello(){
        return "hello muXin";
    }
}
