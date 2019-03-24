package com.zhangran.photo_show.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController  {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/reservation")
    public String reservation(){
        return "reservation";
    }
    @RequestMapping(value = "/reservationAdd")
    public String reservationAdd(){
        return "reservationAdd";
    }
    @RequestMapping(value = "/works")
    public String works(){
        return "works";
    }
    @RequestMapping(value = "/activity")
    public String activity(){
        return "activity";
    }
    @RequestMapping(value = "/affiliate")
    public String affiliate(){
        return "affiliate";
    }
    @RequestMapping(value = "/brand")
    public String brand(){
        return "brand";
    }
}
