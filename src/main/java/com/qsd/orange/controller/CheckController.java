package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.service.CheckService;
import com.qsd.orange.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Esion
 * @Date 2020/9/26 15:41
 * @Version 1.0
 */
@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("add")
    public BaseVo add(
            String id,
            @RequestParam(value = "problem", required = false, defaultValue = "无") String problem,
            @RequestParam(value = "compensate", required = false, defaultValue = "0") Double compensate,
            @RequestParam(value = "description", required = false, defaultValue = "无") String description,
            Authentication authentication
    ){
        User users = (User)authentication.getPrincipal();
        int add = checkService.add(id, problem, compensate, description, users.getUsername());
        return new BaseVo(add > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

}
