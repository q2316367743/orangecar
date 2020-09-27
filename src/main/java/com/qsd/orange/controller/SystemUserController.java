package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import com.qsd.orange.vo.BaseVo;
import com.qsd.orange.vo.DataVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public PageVo<SysUser> all(){
        return new PageVo<>(HttpResult.SUCCESS, userService.all());
    }

    @PostMapping("add")
    public BaseVo add(@Valid SysUser user){
        int add = userService.add(user);
        return new BaseVo(add > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

    @PostMapping("update")
    public BaseVo update(@Valid SysUser user){
        return new BaseVo(userService.update(user) > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

    @GetMapping("reset")
    public BaseVo reset(String username){
        int reset = userService.reset(username);
        return new BaseVo(reset > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

}
