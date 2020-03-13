package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 李小末 on 2019/5/23 17:04
 */
@Controller
public class UeditorController {
    @RequestMapping("/")
    public String show(){
        return "index";
    }
}
