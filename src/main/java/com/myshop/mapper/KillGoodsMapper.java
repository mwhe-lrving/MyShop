package com.myshop.mapper;

import com.myshop.pojo.KillGoods;
import com.myshop.pojo.KillGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface KillGoodsMapper {
    long countByExample(KillGoodsExample example);

    int deleteByExample(KillGoodsExample example);

    int deleteByPrimaryKey(Integer killid);

    int insert(KillGoods record);

    int insertSelective(KillGoods record);

    List<KillGoods> selectByExample(KillGoodsExample example);

    List<KillGoods> selectAllKillGoods();

    KillGoods selectByPrimaryKey(Integer killid);
    KillGoods selectById(Integer killid);

    int updateByExampleSelective(@Param("record") KillGoods record, @Param("example") KillGoodsExample example);

    int updateByExample(@Param("record") KillGoods record, @Param("example") KillGoodsExample example);

    int updateByPrimaryKeySelective(KillGoods record);

    int updateByPrimaryKey(KillGoods record);
}