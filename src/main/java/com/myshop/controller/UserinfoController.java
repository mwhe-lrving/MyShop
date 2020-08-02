package com.myshop.controller;

import com.myshop.pojo.Userinfo;
import com.myshop.service.UserinfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserinfoController {
    @Autowired
    private UserinfoService service;
    @Autowired
    Userinfo userinfo;

    //    @RequestMapping("dologin")
//    public String doLogin(HttpServletRequest request, HttpServletResponse response, Userinfo user) {
//        System.out.println(user + "得到的登录信息*******************************************************");
//        Userinfo realuser = service.login(user);
//        System.out.println("realuser" + realuser + "controller得到的真实对象*******************************************************");
//        if (realuser != null) {
//            request.getSession().setAttribute("loginuser", realuser);
////            modelAndView.setViewName("redirect:admin/index");
//            return "redirect:/index";
//        } else {
//            try {
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().print("<script>alert('登录失败');history.go(-1);</script>");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        return null;
//    }
//使用Shiro编写认证操作
    @RequestMapping("/dologin")
    public String login(String username, String password, Model model) {
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //执行登陆方法
        try {
            subject.login(token);//会去UserRealm执行认证逻辑
            //登陆成功
            System.out.println("登陆成功");
            userinfo.setUsername(username);
            return "redirect:/loginsuccess";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }

    }

    @RequestMapping("/login")
    public String toLogin() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
        System.out.println("loginloginlogin跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转跳转");
        return "login";
    }

    @RequestMapping("/loginsuccess")
    public String loginSuccess(Model model) {

        return "index";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "noAuth";
    }


    @RequestMapping("/regist")
    public String register() {
        return "regist";
    }

    @RequestMapping("doreg")
    public String doRegist(HttpServletRequest request, HttpServletResponse response, Userinfo user) {
        System.out.println(user + "得到的注册信息*******************************************************");
        int result = service.register(user);
        if (result >= 1) {
            return "redirect:/login";//请求login，到登陆页面去
        } else if (result == -1) {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<script>alert('注册失败，用户名重复');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<script>alert('注册失败');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {

        return "hello";
    }

    @RequestMapping("/top")
    public String top(Model model) {
        model.addAttribute("msg", userinfo.getUsername());
        userinfo.setUsername("");
        return "top";
    }

    @RequestMapping("/left")
    public String left(HttpServletRequest request) {
        request.setAttribute("msg", "hello springmvc");

        return "left";
    }
}
