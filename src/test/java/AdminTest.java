import com.myshop.mapper.AdminMapper;
import com.myshop.pojo.Admin;
import com.myshop.pojo.AdminExample;
import com.myshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AdminTest {

    public static void main(String[] args) {

    }

    @Test
    public void testInsertSelective() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = new Admin();
            admin.setUsername("7");
            admin.setPassword("3");
            admin.setRealname("猪八戒");
            System.out.println(mapper.insertSelective(admin));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testupdateSelective() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = new Admin();
            admin.setAdminid(3);
            admin.setUsername("6");
            admin.setPassword("6");
            admin.setRealname("唐僧");
            System.out.println(mapper.updateByPrimaryKey(admin));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void updateExample() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

            Admin admin = new Admin();
            admin.setPassword("888");
            admin.setRealname("唐僧7");

            AdminExample example = new AdminExample();
            AdminExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameLike("6");
            criteria.andAdminidGreaterThan(2);
            criteria = example.or();
            criteria.andUsernameLike("7");
            criteria.andAdminidGreaterThan(4);

            System.out.println(mapper.updateByExampleSelective(admin, example));
            sqlSession.commit();
            System.out.println("update success");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

}
