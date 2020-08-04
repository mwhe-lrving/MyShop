package com.myshop.mapper;

import com.myshop.pojo.KillOrderInfo;
import com.myshop.pojo.KillOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KillOrderInfoMapper {
    long countByExample(KillOrderInfoExample example);

    int deleteByExample(KillOrderInfoExample example);

    int deleteByPrimaryKey(Integer killorderid);

    int insert(KillOrderInfo record);

    int insertSelective(KillOrderInfo record);

    List<KillOrderInfo> selectByExample(KillOrderInfoExample example);

    KillOrderInfo selectByPrimaryKey(Integer killorderid);

    int updateByExampleSelective(@Param("record") KillOrderInfo record, @Param("example") KillOrderInfoExample example);

    int updateByExample(@Param("record") KillOrderInfo record, @Param("example") KillOrderInfoExample example);

    int updateByPrimaryKeySelective(KillOrderInfo record);

    int updateByPrimaryKey(KillOrderInfo record);
}