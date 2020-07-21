package com.myshop.UserinfoService;

import com.myshop.pojo.Userinfo;

public interface UserinfoService {
    public Userinfo login(Userinfo user);

    public Userinfo register(Userinfo user);

    public int logout(Userinfo user);
}
