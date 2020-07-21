package com.myshop.pojo;

public class Userinfo {
    private Integer userid;
    private String username;
    private String password;
    private String realname;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }

    public Userinfo() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Userinfo(Integer userid, String username, String password, String realname) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public Userinfo(String username, String password, String realname) {

        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public Userinfo(String username, String realname) {
        this.username = username;
        this.realname = realname;
    }


}
