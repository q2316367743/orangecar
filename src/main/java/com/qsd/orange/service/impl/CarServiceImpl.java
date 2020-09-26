package com.qsd.orange.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.dao.CarDao;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Esion
 * @Date 2020/9/24 17:01
 * @Version 1.0
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public IPage<BusCar> queryAllCar(Integer page, Integer limit, Integer status) {
        return carDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusCar>().eq(status >= 0, "status", status).orderByDesc("created"));
    }

    @Override
    public IPage<BusCar> queryCar(Integer page, Integer limit, Integer status, String brand, String color) {
        return carDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusCar>()
                        .and(true, i -> i
                        .like(brand != "", "brand", brand)
                        .like(color != "", "color", color))
                    .orderByDesc("created"));
    }

    @Override
    public IPage<BusCar> queryCarByNumber(Integer page, Integer limit, String number) {
        return carDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusCar>()
                        .and(true, i -> i
                        .eq(true, "status", 0)
                        .eq(!number.equals(""), "number", number))
                    .orderByDesc("created"));
    }

    @Override
    public int add(String username, BusCar car) {
        car.setCreated(DateUtil.date().toTimestamp());
        car.setOperator(username);
        car.setStatus(0);
        return carDao.insert(car);
    }

}
