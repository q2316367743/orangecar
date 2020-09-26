package com.qsd.orange.service;

import com.qsd.orange.po.SysUser;

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

}
