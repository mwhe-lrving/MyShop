package com.myshop.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class GoodsComplex extends Goods {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public GoodsComplex(Category category) {
        this.category = category;
    }

    public GoodsComplex() {
    }

    public GoodsComplex(Integer id, String name, Integer price, Integer num, String image, Date createDate, Date updateDate, Integer categoryId, Category category) {
        super(id, name, price, num, image, createDate, updateDate, categoryId);
        this.category = category;
    }

    @Override
    public String toString() {
        return "GoodsComplex{" +
                "category=" + category +
                super.toString() + '}';
    }
}
