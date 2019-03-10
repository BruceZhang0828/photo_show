package com.zhangran.photo_show.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class IndexController  {

    public String index(){
        return "index";
    }
}
