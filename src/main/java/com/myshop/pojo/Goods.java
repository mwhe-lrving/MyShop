package com.myshop.pojo;

import java.util.Date;

public class Goods {
    private Integer id;
    private String name;
    private Integer price;
    private Integer num;
    private String image;
    private Date createDate;
    private Date updateDate;
    private Integer categoryid;
    private Category category;

    public Goods(Integer id, String name, Integer price, Integer num, String image, Date createDate, Date updateDate, Integer categoryid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoryid = categoryid;

    }

    public Goods(Integer id, String name, Integer price, Integer num, Date createDate, Date updateDate, Integer categoryid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;

        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoryid = categoryid;

    }
    public Goods(Integer id, String name, Integer price, Integer num, String image, Date createDate, Date updateDate, Integer categoryid, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoryid = categoryid;
        this.category = category;
    }

    public Goods(String name, Integer price, Integer num, Date createDate, Date updateDate) {

        this.name = name;
        this.price = price;
        this.num = num;
        this.createDate = createDate;
        this.updateDate = updateDate;

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
                ", categoryid=" + categoryid +
                ", category=" + category +
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
        this.image = image;
    }

    public Date getCreateData() {
        return createDate;
    }

    public void setCreateData(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdataData() {
        return updateDate;
    }

    public void setUpdataData(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
