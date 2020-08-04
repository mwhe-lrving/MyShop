package com.myshop.controller;

import com.myshop.pojo.KillGoods;
import com.myshop.pojo.Userinfo;
import com.myshop.service.KillGoodsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/killgoods/")
public class KillGoodsController {
    @Autowired
    private KillGoodsService service;

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<KillGoods> killGoods = service.getAllKillGoods();
        request.setAttribute("killgoods", killGoods);
        return "goods_list";

    }


    @RequestMapping("/view/{killid}")
    public String view(HttpServletRequest request, @PathVariable("killid") Integer killid) {
        KillGoods killgood = service.getKillGoodsById(killid);
        request.setAttribute("goods", killgood);
        long remainSeconds = 0;
        long starttime = killgood.getStartdate().getTime();
        long endtime = killgood.getEnddate().getTime();
        long now = System.currentTimeMillis();
        Integer killStatus = 0;
        if (now < starttime) {//秒杀倒计时
            remainSeconds = (starttime - now) / 1000;
        } else {
            if (now < endtime) {
                System.out.println(endtime-now+"秒杀进行中");
                killStatus = 1;//秒杀进行中
            } else {
                System.out.println(endtime-now+"秒杀结束");
                remainSeconds=-1;
                killStatus = 2;//秒杀结束
            }
        }
        request.setAttribute("goods", killgood);
        request.setAttribute("remainSeconds", remainSeconds);
        request.setAttribute("killStatus", killStatus);
        return "goods_view";

    }

    @RequestMapping("/kill")
    @ResponseBody
    public int kill(HttpServletRequest request, Integer killid) {
        request.getSession();
        Subject subject = SecurityUtils.getSubject();
        Userinfo userinfo = (Userinfo) subject.getPrincipal();
        System.out.println(userinfo+"1231231231232111111111111111111111111111111111111111111");
        int result = service.kill(userinfo.getUserid(), killid);
        return result;
    }

}
