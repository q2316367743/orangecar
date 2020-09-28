package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.BusCheck;
import com.qsd.orange.service.CheckService;
import com.qsd.orange.vo.DataVo;
import com.qsd.orange.vo.PageVo;
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
    public PageVo<BusCheck> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return new PageVo<>(HttpResult.SUCCESS, checkService.all(page, limit));
    }

    @GetMapping("search")
    public DataVo search(String id){
        return new DataVo(HttpResult.SUCCESS, checkService.search(id));
    }

}
