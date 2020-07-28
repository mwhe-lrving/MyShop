package com.myshop.controller;

import com.myshop.pojo.Userinfo;
import com.myshop.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserinfoController {
    @Autowired
    private UserinfoService service;

    @RequestMapping("dologin")
    public String doLogin(HttpServletRequest request, HttpServletResponse response, Userinfo user) {
        System.out.println(user + "得到的登录信息*******************************************************");
        Userinfo realuser = service.login(user);
        System.out.println("realuser" + realuser + "controller得到的真实对象*******************************************************");
        if (realuser != null) {
            request.getSession().setAttribute("loginuser", realuser);
//            modelAndView.setViewName("redirect:admin/index");
            return "redirect:admin/index";
        } else {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<script>alert('登录失败');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @RequestMapping("/login")
    public String toLogin() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
        return "login";
    }
}
