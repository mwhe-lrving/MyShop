package com.myshop.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class KillGoods extends Goods {
    private Integer killid;

    private Integer goodsid;

    private Integer stockcount;

    private Date startdate;

    private Date enddate;

    private BigDecimal killprice;

    public Integer getKillid() {
        return killid;
    }

    public void setKillid(Integer killid) {
        this.killid = killid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public BigDecimal getKillprice() {
        return killprice;
    }

    public void setKillprice(BigDecimal killprice) {
        this.killprice = killprice;
    }
}