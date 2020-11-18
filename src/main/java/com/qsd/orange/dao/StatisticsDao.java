package com.qsd.orange.dao;

import com.qsd.orange.vo.StatisticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Esion
 * @Date 2020/11/17 19:49
 * @Version 1.0
 */
@Mapper
public interface StatisticsDao {

    /**
     * 获取地区统计
     * */
    List<StatisticsVo> getRegionVo();
    /**
     * 业务员年度销售额
     * @param year 年份
     * */
    List<StatisticsVo> getSalesman(@Param("year") String year);

    List<Integer> getCompany(@Param("year") String year);
}
