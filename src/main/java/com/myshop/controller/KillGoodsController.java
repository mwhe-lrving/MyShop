package com.myshop.controller;

import com.myshop.pojo.KillGoods;
import com.myshop.pojo.OrderInfo;
import com.myshop.pojo.Userinfo;
import com.myshop.service.KillGoodsService;
import com.myshop.utils.JsonResult;
import com.myshop.utils.RedisUtils;
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
    private RedisUtils redisUtils = new RedisUtils();

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:展示秒杀商品
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List killGoods = redisUtils.getList("killgoods", KillGoods.class);
        if (killGoods != null) {
            System.out.println(killGoods.get(0));
            request.setAttribute("killgoods", killGoods);
            System.out.println("从redis拿数据");
            return "goods_list";
        }
        List killGoodsMysql = service.getAllKillGoods();
        System.out.println("从mysql拿数据");
        System.out.println("存入缓存");
        redisUtils.setList("killgoods", killGoodsMysql);
        request.setAttribute("killgoods", killGoodsMysql);
        return "goods_list";

    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:跳转到秒杀页面
     */
    @RequestMapping("/toview/{killid}")
    public String toview(HttpServletRequest request, @PathVariable(name = "killid") Integer killid) {
        request.setAttribute("killid", killid);
        return "goods_view";
    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:供给页面ajax请求
     */
    @RequestMapping("/view/{killid}")
    @ResponseBody
    public JsonResult view(HttpServletRequest request, @PathVariable("killid") Integer killid) {
        System.out.println(killid + "接收前台传回来的信息");
        KillGoods killgood = new KillGoods();
        //先从redis拿
        killgood = (KillGoods) redisUtils.get("killgood", KillGoods.class);
        System.out.println(killgood);
        if (killgood != null&&killgood.getKillid()==killid) {
            request.setAttribute("killgood", killgood);
            System.out.println("从redis拿数据");
        } else {
            System.out.println("从mysql拿数据,存入redis");
            killgood = service.getKillGoodsById(killid);
            redisUtils.set("killgood", killgood);
            request.setAttribute("goods", killgood);
        }
        long remainSeconds = 0;
        long starttime = killgood.getStartdate().getTime();
        long endtime = killgood.getEnddate().getTime();
        long now = System.currentTimeMillis();
        Integer killStatus = 0;
        if (now < starttime) {//秒杀倒计时
            remainSeconds = (starttime - now) / 1000;
        } else {
            if (now < endtime) {
                System.out.println(endtime - now + "秒杀进行中");
                killStatus = 1;//秒杀进行中
            } else {
                System.out.println(endtime - now + "秒杀结束");
                remainSeconds = -1;
                killStatus = 2;//秒杀结束
            }
        }
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(killgood);
        jsonResult.setMsg(remainSeconds + "");
        jsonResult.setStatusCode(killStatus);
        //request.setAttribute("goods", killgood);
        //request.setAttribute("remainSeconds", remainSeconds);
        //request.setAttribute("killStatus", killStatus);
        System.out.println(jsonResult);
        return jsonResult;
    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:秒杀按钮
     */
    @RequestMapping("/kill/{killid}")
    @ResponseBody
    public int kill(HttpServletRequest request, @PathVariable("killid") Integer killid) {
        request.getSession();
        //通过shiro拿登陆用户信息
        Subject subject = SecurityUtils.getSubject();
        Userinfo userinfo = (Userinfo) subject.getPrincipal();
        System.out.println(userinfo + "1231231231232111111111111111111111111111111111111111111");
        //先从redis拿
        String resultstr = (String) redisUtils.get("result", String.class);
        if (resultstr != null) {
            System.out.println("redis拿数据");
            return Integer.parseInt(resultstr);
        } else {
            System.out.println("从mysql拿数据,存入redis");
            int result = service.kill(userinfo.getUserid(), killid);
            redisUtils.set("result", result + "");
            return result;
        }

    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:去订单界面
     */
    @RequestMapping("/toorder")
    public String toorder() {
        return "order_view";
    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:供给页面ajax请求
     */
    @RequestMapping("/order/{killorderid}")
    @ResponseBody
    public JsonResult viewOrder(HttpServletRequest request, @PathVariable(name = "killorderid") Integer killorderid) {
        System.out.println(killorderid + "前台传过来的秒杀订单id");

        RedisUtils redisUtils = new RedisUtils();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo = (OrderInfo) redisUtils.get("orderInfo", OrderInfo.class);
       Integer killorderidflag = (Integer) redisUtils.get("killorderid",Integer.class );
        if (orderInfo != null&&killorderid!=killorderid) {
            //redis拿数据
            System.out.println("redis拿数据");
            System.out.println(orderInfo + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            JsonResult jsonResult = new JsonResult();
            jsonResult.setData(orderInfo);
            System.out.println(jsonResult);
            return jsonResult;
        } else {
            System.out.println("从mysql拿数据,存入redis");
            orderInfo = service.getOrderByKillOrderid(killorderid);
            redisUtils.set("orderInfo", orderInfo);
            redisUtils.set("killorderid", killorderid);
            JsonResult jsonResult = new JsonResult();
            jsonResult.setData(orderInfo);
            System.out.println(jsonResult);
            return jsonResult;
        }
    }
}
