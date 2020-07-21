package com.myshop.mapper;

import com.myshop.pojo.Userinfo;

import java.util.HashMap;
import java.util.List;

public interface UserinfoMapper {
    public Userinfo selectById(int id);

    public Userinfo selectByUsername(String username);

    public List selectAll();

    public List selectByPage(HashMap map);

    public int selectCount();

    public int insertUser(Userinfo userinfo);

    public int updateById(Userinfo userinfo);

    public int deleteById(int id);


}
