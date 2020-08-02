package com.myshop.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Goods {
    private Integer id;

    private String name;

    private Integer price;

    private Integer num;


    private String image;

    private Date createDate;

    private Date updateDate;

    private Integer categoryId;

    public Goods() {
    }

    public Goods(Integer id, String name, Integer price, Integer num, String image, Date createDate, Date updateDate, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoryId = categoryId;
    }

    public Goods(String name, Integer price, Integer num, String image, Date createDate, Date updateDate, Integer categoryId) {

        this.name = name;
        this.price = price;
        this.num = num;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", categoryId=" + categoryId +
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}