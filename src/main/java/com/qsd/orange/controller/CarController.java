package com.qsd.orange.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.service.CarService;
import com.qsd.orange.vo.BaseVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

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
    public PageVo<BusCar> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1")Integer status
    ){
        IPage<BusCar> cars = carService.queryAllCar(page, limit, status);
        return new PageVo<>(HttpResult.SUCCESS, cars);
    }

    @GetMapping("search")
    public PageVo<BusCar> search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "status", required = false, defaultValue = "-1") Integer status,
            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(value = "color", required = false, defaultValue = "") String color
    ){
        IPage<BusCar> cars = carService.queryCar(page, limit, status, brand, color);
        return new PageVo<>(HttpResult.SUCCESS, cars);
    }

    @GetMapping("search/number")
    public PageVo<BusCar> number(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            @RequestParam(value = "number", required = false, defaultValue = "") String number
    ){
        IPage<BusCar> cars = carService.queryCarByNumber(page, limit, number);
        return new PageVo<>(HttpResult.SUCCESS, cars);
    }

    @PostMapping("add")
    public BaseVo add(BusCar car, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        int add = carService.add(username, car);
        return new BaseVo(add > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

}
