package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.SysUser;

import java.util.List;

/**
 * @Author Esion
 * @Date 2020/9/23 19:07
 * @Version 1.0
 */
public interface UserService {

    /**
     * 注册一个用户
     * @param user 用户信息
     * */
    int register(SysUser user);
    /**
     * 更新用户信息
     * @param user 用户信息
     * */
    boolean update(SysUser user);
    /**
     * 获取用户信息
     * @param username 用户名
     * */
    SysUser getInfo(String username);
    /**
     * 查询全部用户，不包括管理员
     * */
    List<SysUser> all();

}
