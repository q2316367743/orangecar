package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.BusRent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/25 19:10
 * @Version 1.0
 */
@Mapper
public interface RentDao extends BaseMapper<BusRent> {
}
