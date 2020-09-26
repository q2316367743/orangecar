package com.qsd.orange.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.dao.CarDao;
import com.qsd.orange.dao.RentDao;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Author Esion
 * @Date 2020/9/25 17:41
 * @Version 1.0
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private CarDao carDao;
    @Autowired
    private RentDao rentDao;

    @Override
    public int add(String identity, String number, String returnTime, String username) {
        //查找车辆信息
        BusCar car = carDao.selectById(number);
        if (car == null){
            return -2;
        }
        if (car.getStatus() == 1){
            return -1;
        }
        BusRent rent = new BusRent();
        rent.setCreated(DateUtil.date().toTimestamp());
        rent.setBeginTime(DateUtil.date().toSqlDate());
        rent.setRentStatus(0);
        rent.setCarNumber(number);
        rent.setReturnTime(DateUtil.parse(returnTime).toSqlDate());
        rent.setOperator(username);
        rent.setPrice(car.getRentPrice());
        rent.setCustomerIdentity(identity);
        rent.setId("CZ_" + DateUtil.date().toString("yyyyMMdd") + "_" + String.valueOf(System.currentTimeMillis()) + "_" + RandomUtil.randomNumbers(4));
        int insert = rentDao.insert(rent);
        if (insert == 0){
            return 0;
        }
        //修改汽车状态
        BusCar busCar = new BusCar();
        busCar.setNumber(number);
        busCar.setStatus(1);
        return carDao.updateById(busCar);
    }

    @Override
    public IPage<BusRent> all(Integer page, Integer limit) {
        return rentDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusRent>()
                        .eq("rent_status", 0)
                        .orderByDesc("created"));
    }

    @Override
    public IPage<BusRent> search(Integer page, Integer limit, String type, String keyword) {
        return rentDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusRent>()
                        .and(true, i -> i
                                .eq("rent_status", 0)
                                .like(type, keyword))
                        .orderByDesc("created"));
    }

}
