import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myshop.mapper.GoodsMapper;
import com.myshop.pojo.Goods;
import com.myshop.pojo.GoodsComplex;
import com.myshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class GoodsTest {


    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            GoodsComplex goodsComplex = goodsMapper.selectComplexByPrimaryKey(1);
            System.out.println(goodsComplex);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            Goods goods = new Goods("牛油果", 10000, 100, "//image", new Date(), new Date(), 1);
            goodsMapper.insert(goods);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectPageHelper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

            //向threadlocal里面储存分页信息
            PageHelper.startPage(2, 3);
            //执行查询之前会自动执行分页的拦截器：他会先读取thread local里面的分页信息，重新组装sql
            //然后执行sql
            List<Goods> goodsList = goodsMapper.selectByExample(null);
            PageInfo pageInfo=new PageInfo(goodsList);
            System.out.println(pageInfo.getPages());
            System.out.println(pageInfo);
            for (int i = 0; i < goodsList.size(); i++) {
                System.out.println(goodsList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
