package com.qsd.orange.controller;

import com.qsd.orange.po.BusCar;
import com.qsd.orange.service.CarService;
import com.qsd.orange.global.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Esion
 * @Date 2020/9/24 16:29
 * @Version 1.0
 */
@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("all")
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1")Integer status
    ){
        return R.success().page(carService.queryAllCar(page, limit, status));
    }

    @GetMapping("search")
    public R search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1") Integer status,
            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(value = "color", required = false, defaultValue = "") String color
    ){
        return R.success().page(carService.queryCar(page, limit, status, brand, color));
    }

    @GetMapping("search/number")
    public R number(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "number", required = false, defaultValue = "") String number
    ){
        return R.success().page(carService.queryCarByNumber(page, limit, number));
    }

    @PostMapping("add")
    public R add(@Valid BusCar car, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        return R.choose(carService.add(username, car) > 0);
    }

}
