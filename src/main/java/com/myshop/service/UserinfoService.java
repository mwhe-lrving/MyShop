package com.myshop.service;

import com.myshop.pojo.Userinfo;

public interface UserinfoService {
    public Userinfo login(Userinfo user);

    public int register(Userinfo user);

    public int logout(Userinfo user);
}
