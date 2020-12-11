package com.qsd.orange.service.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qsd.orange.dao.UserDao;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int add(SysUser user) {
        user.setType(0);
        //设置密码
        String password = passwordEncoder.encode("123456");
        user.setPassword(password);
        return userDao.insert(user);
    }

    @Override
    public int update(SysUser user) {
        return userDao.updateById(user);
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        SysUser user = userDao.selectById(username);
        //真实密码
        String password = user.getPassword();
        //判断原密码是否正确
        if (!passwordEncoder.matches(oldPassword, password)){
            return -2;
        }
        newPassword = passwordEncoder.encode(newPassword);
        //判断新密码与原密码是否相同
        if (password.equals(newPassword)){
            return -1;
        }
        SysUser up = new SysUser();
        up.setUsername(username);
        up.setPassword(newPassword);
        return userDao.updateById(up);
    }

    @Override
    public SysUser getInfo(String username) {
        return userDao.selectOneById(username);
    }

    @Override
    public List<SysUser> all() {
        return userDao.selectList(new QueryWrapper<SysUser>().eq("type", 0));
    }

    @Override
    public int reset(String username) {
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("123456"));
        return userDao.updateById(user);
    }

}
