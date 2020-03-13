package com.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("u")
public class demoController {
    @RequestMapping("g")
    public  String game(){
        return "你好再见！";
    }

}
