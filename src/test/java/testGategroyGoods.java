import com.myshop.mapper.CategoryMapper;
import com.myshop.mapper.GoodsMapper;
import com.myshop.pojo.Category;
import com.myshop.pojo.Goods;
import com.myshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class testGategroyGoods {
//    @Test
//    public void testInsertCategory() {
//        Category category = new Category();
//        category.setGoodsnum(0);
//        category.setName("零食");
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
//            int result = categoryMapper.insertCategory(category);
//            sqlSession.commit();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//
//    }
//
//    @Test
//    public void testInsertGoods() {
//        Date date = new Date();
//        Goods goods = new Goods("香瓜", 10000, 100, date, date);
//        goods.setCategoryid(1);
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
//            int result = goodsMapper.insertGoods(goods);
//            System.out.println(goods.getId() + "得到id");
//            sqlSession.commit();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    @Test
//    public void testSeleteById() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
//            Goods goods1 = goodsMapper.selectById(1);
//            sqlSession.commit();
//            System.out.println(goods1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    @Test
//    public void testGetCategory() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
//            Category category = mapper.selectById(1);
//            System.out.println(category);
//            System.out.println("------------------------------------------------");
//            category = mapper.selectCategoryGoodsById(1);
//            System.out.println(category);
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    @Test
//    public void testGetJoinGoods() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
//            Goods goods1 = goodsMapper.selectByJoinId(1);
//            System.out.println(goods1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    @Test
//    public void testShearch() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
//            Map map = new HashMap();
//            Goods goods = new Goods();
//            goods.setName("%苹%");
//            goods.setCategoryid(1);
////            map.put("condition",goods);
////            map.put("startindex",0);
////            map.put("pagesize",5);
//            List<Goods> goodlist = goodsMapper.search(goods, 0, 5);
//            for (int i = 0; i < goodlist.size(); i++) {
//                System.out.println(goodlist.get(i));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    @Test
//    public void testdelMany() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
////            List<Goods> ids=new ArrayList<Goods>();
////            for (int i = 10; i < 13; i++) {
////                ids.add(new Goods(i));
////            }
//            Integer[] ids = new Integer[3];
//            ids[0] = 12;
//            ids[1] = 13;
//            ids[2] = 14;
//            goodsMapper.delManyByIds(ids);
//            sqlSession.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    } @Test
//    public void testupdate() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        try {
//            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
//            Goods goods = new Goods();
//            goods.setId(17);
//            goods.setName("香瓜");
//            goods.setPrice(99999999);
//            System.out.println(goodsMapper.updateSelectiveGoods(goods));
//            sqlSession.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            sqlSession.close();
//        }
//    }
}
