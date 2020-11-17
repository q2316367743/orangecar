package com.qsd.orange.controller;

import com.qsd.orange.global.R;
import com.qsd.orange.po.BusCheck;
import com.qsd.orange.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Esion
 * @Date 2020/9/28 17:00
 * @Version 1.0
 */
@RestController
@RequestMapping("system/check")
public class SystemCheckController {

    @Autowired
    private CheckService checkService;

    @GetMapping("all")
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return R.success().page(checkService.all(page, limit));
    }

    @GetMapping("search")
    public R search(String id){
        return R.success().data("item", checkService.search(id));
    }

}
