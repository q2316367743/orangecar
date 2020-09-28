package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.BusCar;

/**
 * @Author Esion
 * @Date 2020/9/24 16:31
 * @Version 1.0
 */
public interface CarService {

    /**
     * 查询全部汽车
     * @param page 页码
     * @param limit 每页数目
     * @param status 是否出租
     * */
    IPage<BusCar> queryAllCar(Integer page, Integer limit, Integer status);
    /**
     * 查询全部汽车
     * @param page 页码
     * @param limit 每页数目
     * @param status 是否出租
     * @param brand 汽车品牌
     * @param color 汽车颜色
     * */
    IPage<BusCar> queryCar(Integer page, Integer limit, Integer status, String brand, String color);
    /**
     * 查询全部汽车
     * 管理员
     * */
    IPage<BusCar> queryAllCarSys(Integer page, Integer limit, Integer status);
    /**
     * 查询全部汽车
     * 管理员
     * */
    IPage<BusCar> queryCarSys(Integer page, Integer limit, Integer status, String brand, String color);
    IPage<BusCar> queryCarByNumber(Integer page, Integer limit, String number);
    /**
     * 增加一个车辆信息
     * @param username 用户名
     * @param car 汽车信息
     * */
    int add(String username, BusCar car);
    /**
     * 修改车辆信息
     * @param car 车辆信息
     * */
    int update(BusCar car);
    /**
     * 修改车辆状态，是否启用/报废
     * @param number 车牌号
     * @param exist 状态
     * */
    int updateExist(String number, Integer exist);

}
