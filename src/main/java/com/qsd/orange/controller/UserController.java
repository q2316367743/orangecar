package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import com.qsd.orange.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Esion
 * @Date 2020/9/27 15:40
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("update/info")
    public BaseVo updateInfo(SysUser user, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        user.setUsername(username);
        return new BaseVo(userService.update(user) > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

    @PostMapping("update/password")
    public BaseVo updatePassword(String oldPassword, String newPassword, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        int i = userService.updatePassword(username, oldPassword, newPassword);
        switch (i){
            case -2:
                return new BaseVo(HttpResult.USERNAME_OR_PASSWORD_ERROR);
            case -1:
                return new BaseVo(HttpResult.PASSWORD_NOT_SAME);
            case 1:
                return new BaseVo(HttpResult.SUCCESS);
            default:
                return new BaseVo(HttpResult.SERVER_ERROR);
        }
    }

}
