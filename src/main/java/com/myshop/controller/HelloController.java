package com.myshop.controller;

import com.myshop.pojo.Userinfo;
import com.myshop.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

@Controller
public class HelloController {
    @Autowired
    private UserinfoService userinfoService;

    //    @RequestMapping("/hello")
//    public ModelAndView hello() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("hello");
//        modelAndView.addObject("msg", "hello springmvc");
//        return modelAndView;
//    }
//    @RequestMapping("/hello")
//    public String hello(HttpServletRequest request) {
//
//        return "hello";
//    }
//    @RequestMapping("/top")
//    public String top() {
//
//
//        return "top";
//    }
//
//    @RequestMapping("/left")
//    public String left(HttpServletRequest request) {
//        request.setAttribute("msg", "hello springmvc");
//        return "left";
//    }
 }
