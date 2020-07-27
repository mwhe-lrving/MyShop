package com.myshop.pojo;

import java.util.List;

public class CategroyComplex extends Category {
    private List<Goods> goodsitems;

    public CategroyComplex(List<Goods> goodsitems) {
        this.goodsitems = goodsitems;
    }

    public CategroyComplex() {
    }

    @Override
    public String toString() {
        return "CategroyComplex{" +
                "goodsitems=" + goodsitems +
                '}'+super.toString();
    }

    public List<Goods> getGoodsitems() {
        return goodsitems;
    }

    public void setGoodsitems(List<Goods> goodsitems) {
        this.goodsitems = goodsitems;
    }
}
