package com.qsd.orange.service.impl;

import com.qsd.orange.dao.UserDao;
import com.qsd.orange.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author Esion
 * @Date 2020/9/14 19:05
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userDao.selectById(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名没有找到");
        }
        return new User(username,
                user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getType().toString()));
    }
}
