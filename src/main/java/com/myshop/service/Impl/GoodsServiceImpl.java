package com.myshop.service.Impl;

import com.myshop.mapper.GoodsMapper;
import com.myshop.pojo.Goods;
import com.myshop.service.GoodsService;
import com.myshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper mapper;

    public List<Goods> getAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Goods> goods = null;
        try {
            mapper = sqlSession.getMapper(GoodsMapper.class);
            goods = mapper.selectByExample(null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return goods;
    }
}
