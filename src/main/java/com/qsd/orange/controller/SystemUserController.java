package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import com.qsd.orange.vo.DataVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
