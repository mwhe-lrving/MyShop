package com.myshop.mapper;

import com.myshop.pojo.OrderInfo;
import com.myshop.pojo.OrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInfoMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}