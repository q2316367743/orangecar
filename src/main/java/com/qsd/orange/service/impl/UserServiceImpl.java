package com.qsd.orange.service.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qsd.orange.dao.UserDao;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Esion
 * @Date 2020/9/23 19:18
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(SysUser user) {
        return 0;
    }

    @Override
    public boolean update(SysUser user) {
        return false;
    }

    @Override
    public SysUser getInfo(String username) {
        return userDao.selectById(username);
    }

    @Override
    public List<SysUser> all() {
        return userDao.selectList(new QueryWrapper<SysUser>().eq("type", 0));
    }

}
