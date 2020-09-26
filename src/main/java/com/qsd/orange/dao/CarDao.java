package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.BusCar;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/24 17:11
 * @Version 1.0
 */
@Mapper
public interface CarDao extends BaseMapper<BusCar> {
}
