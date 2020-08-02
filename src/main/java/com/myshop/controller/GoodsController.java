package com.myshop.controller;

import com.myshop.pojo.Goods;
import com.myshop.service.GoodsService;
import com.sun.media.sound.FFT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/goods/")
public class GoodsController {
    @Autowired
    private GoodsService service;

    //    @ResponseBody//加了这个后不会走视图解析器
//    @RequestMapping(value = "/getall", produces = "application/json;charset=utf-8")


    @RequestMapping("/getall")
    @ResponseBody
    public List<Goods> getGoods() {
        return service.getAll();
    }


}
