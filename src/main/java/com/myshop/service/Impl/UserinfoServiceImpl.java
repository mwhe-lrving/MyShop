package com.myshop.service.Impl;

import com.myshop.service.UserinfoService;
import com.myshop.mapper.UserinfoMapper;
import com.myshop.pojo.Userinfo;
import com.myshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService {
    private UserinfoMapper mapper;
    SqlSession sqlSession = null;

    public Userinfo login(Userinfo user) {
        sqlSession = MybatisUtils.getSqlSession();
        Userinfo result = null;
        try {
            mapper = sqlSession.getMapper(UserinfoMapper.class);
            Userinfo realuser = mapper.selectByUsername(user.getUsername());

            if (realuser != null) {
                if (realuser.getPassword().equalsIgnoreCase(user.getPassword())) {
                    result = realuser;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          MybatisUtils.closeSqlSession(sqlSession);
        }
        return result;
    }


    public int register(Userinfo user) {
        sqlSession = MybatisUtils.getSqlSession();
        int result = 0;
        try {
            mapper = sqlSession.getMapper(UserinfoMapper.class);
            Userinfo realuser = mapper.selectByUsername(user.getUsername());
            if (realuser == null) {
                result = mapper.insertUser(user);
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
        return result;
    }

    public int logout(Userinfo user) {
        return 0;
    }
}
