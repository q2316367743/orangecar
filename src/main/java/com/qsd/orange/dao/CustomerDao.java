package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.BusCustomer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/23 21:20
 * @Version 1.0
 */
@Mapper
public interface CustomerDao extends BaseMapper<BusCustomer> {
}
