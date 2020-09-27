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
     * @return 1：成功，0：失败
     * */
    int add(SysUser user);
    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 1：成功，0：失败
     * */
    int update(SysUser user);
    /***
     * 更新密码
     * @param username 要更新的用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 0：失败，1：成功，-1:未变，-2：原密码错误
     */
    int updatePassword(String username, String oldPassword, String newPassword);
    /**
     * 获取用户信息
     * @param username 用户名
     * */
    SysUser getInfo(String username);
    /**
     * 查询全部用户，不包括管理员
     * */
    List<SysUser> all();
    /**
     * 将用户密码重置为123456
     * @param username 用户名
     * */
    int reset(String username);

}
