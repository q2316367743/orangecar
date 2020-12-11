package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/23 19:03
 * @Version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<SysUser> {

    SysUser selectOneById(String username);

}
