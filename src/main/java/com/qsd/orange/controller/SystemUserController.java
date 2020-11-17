package com.qsd.orange.controller;

import com.qsd.orange.global.R;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Esion
 * @Date 2020/9/26 18:39
 * @Version 1.0
 */
@RestController
@RequestMapping("system/user")
public class SystemUserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public R all(){
        return R.success().data("items", userService.all());
    }

    @PostMapping("add")
    public R add(@Valid SysUser user){
        return R.choose(userService.add(user) > 0);
    }

    @PostMapping("update")
    public R update(@Valid SysUser user){
        return R.choose(userService.update(user) > 0);
    }

    @GetMapping("reset")
    public R reset(String username){
        return R.choose(userService.reset(username) > 0);
    }

}
