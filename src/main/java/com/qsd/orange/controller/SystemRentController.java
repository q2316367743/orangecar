package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import com.qsd.orange.vo.DataVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Esion
 * @Date 2020/9/27 20:10
 * @Version 1.0
 */
@RestController
@RequestMapping("system/rent")
public class SystemRentController {

    @Autowired
    private RentService rentService;

    @GetMapping("all")
    public PageVo<BusRent> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return new PageVo<>(HttpResult.SUCCESS, rentService.sysAll(page, limit));
    }

    @GetMapping("search")
    public PageVo<BusRent> search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            Integer status,
            String keyword,
            Integer type
    ){
        switch (type){
            case 0:
                return new PageVo<>(HttpResult.SUCCESS, rentService.sysSearch(page, limit, status, "id", keyword));
            case 1:
                return new PageVo<>(HttpResult.SUCCESS, rentService.sysSearch(page, limit, status, "customer_identity", keyword));
            case 2:
                return new PageVo<>(HttpResult.SUCCESS, rentService.sysSearch(page, limit, status, "car_number", keyword));
            default:
                return new PageVo<>(HttpResult.PARAM_ERROR);
        }
    }


}
