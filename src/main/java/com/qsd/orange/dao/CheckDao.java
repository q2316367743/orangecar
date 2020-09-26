package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.BusCheck;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/26 16:08
 * @Version 1.0
 */
@Mapper
public interface CheckDao extends BaseMapper<BusCheck> {
}
