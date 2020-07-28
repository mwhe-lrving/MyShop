package com.myshop.controller;

import com.myshop.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        request.setAttribute("msg", "hello springmvc");
        return "hello";
    }
}
