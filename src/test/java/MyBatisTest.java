import com.myshop.service.UserinfoService;
import com.myshop.service.Impl.UserinfoServiceImpl;
import com.myshop.mapper.UserinfoMapper;
import com.myshop.pojo.Userinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class MyBatisTest {
    @Test
    public void teService(){
        UserinfoService userinfoService=new UserinfoServiceImpl();
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("sunwukong");
        userinfo.setPassword("123456");

        Userinfo result = userinfoService.login(userinfo);
        System.out.println(result);
    }
    @Test
    public void testSelect() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Userinfo userinfo = sqlSession.selectOne("UserinfoMapper.selectById", 1);
            System.out.println(userinfo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void testSelectByPage() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            HashMap map=new HashMap();
            map.put("startindex",0);
            map.put("pagesize",2);
            Userinfo user = new Userinfo("%he%", "%何%");
            map.put("condition",user);
            List userinfos = sqlSession.selectList("UserinfoMapper.selectByPage",map);
            for (int i = 0; i <userinfos.size() ; i++) {
                System.out.println(userinfos.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
    @Test
    public void testSelectAll() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            UserinfoMapper mapper = sqlSession.getMapper(UserinfoMapper.class);
            List userinfos = mapper.selectAll();
//            List userinfos = sqlSession.selectList("UserinfoMapper.selectAll");
            for (int i = 0; i <userinfos.size() ; i++) {
                System.out.println(userinfos.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }   @Test
    public void testSelectCount() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
           int result= sqlSession.selectOne("UserinfoMapper.selectCount");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
    @Test
    public void testInsert() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            Userinfo user = new Userinfo("su3ukong", "123234", "s");
            int result = sqlSession.insert("UserinfoMapper.insertUser", user);
//            sqlSession.commit();
            System.out.println(user);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void testUpdata() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            Userinfo user = new Userinfo(11, "wrwe", "123", "个人");
            sqlSession.update("UserinfoMapper.updateById", user);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void testDelete() {
        String resource = "mybatis/Configuration.xml";
        Reader reader;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            sqlSession.delete("UserinfoMapper.deleteById", 11);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }



}
