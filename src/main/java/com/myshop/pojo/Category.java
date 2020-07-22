package com.myshop.pojo;

public class Category {
    private Integer id;
    private String name;
    private Integer goodsnum;

    public Category(String name, Integer goodsnum) {
        this.name = name;
        this.goodsnum = goodsnum;
    }

    public Category(Integer id, String name, Integer goodsnum) {
        this.id = id;
        this.name = name;
        this.goodsnum = goodsnum;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsnum=" + goodsnum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }
}
