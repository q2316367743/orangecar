package com.qsd.orange.controller;

import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return R.success().page(rentService.sysAll(page, limit));
    }

    @GetMapping("search")
    public R search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            Integer status,
            String keyword,
            Integer type
    ){
        switch (type){
            case 0:
                return R.success().page(rentService.sysSearch(page, limit, status, "id", keyword));
            case 1:
                return R.success().page(rentService.sysSearch(page, limit, status, "customer_identity", keyword));
            case 2:
                return R.success().page(rentService.sysSearch(page, limit, status, "car_number", keyword));
            default:
                return R.error(HttpResult.PARAM_ERROR);
        }
    }


}
