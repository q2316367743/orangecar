package com.qsd.orange.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.global.R;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Esion
 * @Date 2020/9/28 15:18
 * @Version 1.0
 */
@RestController
@RequestMapping("system/car")
public class SystemCarController {

    @Autowired
    private CarService carService;

    @GetMapping("all")
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1")Integer status
    ){
        return R.success().page(carService.queryAllCarSys(page, limit, status));
    }

    @GetMapping("search")
    public R search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1") Integer status,
            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(value = "color", required = false, defaultValue = "") String color
    ){
        return R.success().page(carService.queryCarSys(page, limit, status, brand, color));
    }

    @PostMapping("add")
    public R add(@Valid BusCar car, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        return R.choose(carService.add(username, car) > 0);
    }

    @PostMapping("update/all")
    public R add(@Valid BusCar car){
        return R.choose(carService.update(car) > 0);
    }

    @PostMapping("update/exist/enable")
    public R enable(String number){
        return R.choose(carService.updateExist(number, 1) > 0);
    }

    @PostMapping("update/exist/unable")
    public R unable(String number){
        return R.choose(carService.updateExist(number, 0) > 0);
    }

}
