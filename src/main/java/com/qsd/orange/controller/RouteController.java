package com.qsd.orange.controller;

import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Esion
 * @Date 2020/9/27 14:21
 * @Version 1.0
 */
@Controller
public class RouteController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        SysUser user = userService.getInfo(users.getUsername());
        model.addAttribute("name", user.getName());
        model.addAttribute("type", user.getType());
        return "index";
    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("self")
    public String self(Model model, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        SysUser user = userService.getInfo(users.getUsername());
        model.addAttribute("user", user);
        return "self";
    }

}
