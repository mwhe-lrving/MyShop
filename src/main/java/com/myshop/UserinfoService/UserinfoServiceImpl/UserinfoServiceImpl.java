package com.myshop.UserinfoService.UserinfoServiceImpl;

import com.myshop.UserinfoService.UserinfoService;
import com.myshop.mapper.UserinfoMapper;
import com.myshop.pojo.Userinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserinfoServiceImpl implements UserinfoService {
    private UserinfoMapper mapper;
    SqlSession sqlSession = null;

    public UserinfoServiceImpl() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(UserinfoMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Userinfo login(Userinfo user) {
        Userinfo realuser = mapper.selectByUsername(user.getUsername());
        Userinfo result = null;
        if (realuser != null) {
            if (realuser.getPassword().equalsIgnoreCase(user.getPassword())) {
                result = realuser;
            }
        }
        sqlSession.close();
        return result;
    }


    public Userinfo register(Userinfo user) {
        return null;
    }
}
