package com.qsd.orange.dao;

import com.qsd.orange.vo.RegionVo;
import org.apache.ibatis.annotations.Mapper;

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
    List<RegionVo> getRegionVo();

}
