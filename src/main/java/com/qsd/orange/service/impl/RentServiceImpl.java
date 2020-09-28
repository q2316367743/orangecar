package com.qsd.orange.service.impl;

import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.dao.CarDao;
import com.qsd.orange.dao.CustomerDao;
import com.qsd.orange.dao.RentDao;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.po.BusCustomer;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private CustomerDao customerDao;

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
        rent.setId("CZ_" + DateUtil.date().toString("yyyyMMdd") + "_" + System.currentTimeMillis() + "_" + RandomUtil.randomNumbers(4));
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

    @Override
    public int updateReturnTime(String id, String returnTime) {
        //首先获取原本开始日期、归还日期
        BusRent rent = rentDao.selectById(id);
        if (rent == null){
            return 0;
        }
        DateTime returnDate = null;
        try {
            returnDate = DateUtil.parse(returnTime);
        }catch (DateException e){
            return -3;
        }
        if (returnDate.isBefore(rent.getBeginTime())){
            return -1;
        }
        if (returnDate.isBefore(DateUtil.date())){
            return -2;
        }
        if (returnDate.compareTo(rent.getReturnTime()) == 0){
            return 1;
        }
        BusRent newRent = new BusRent();
        newRent.setId(id);
        newRent.setReturnTime(returnDate.toSqlDate());
        //进行比对
        return rentDao.updateById(newRent);
    }

    @Override
    public Map<String, Object> info(String id) {
        Map<String, Object> info = new HashMap<>();
        //出租单、车辆信息、客户信息
        BusRent rent = rentDao.selectById(id);
        if (rent == null){
            info.put("status", 0);
            return info;
        }
        if (rent.getRentStatus() == 1){
            info.put("status", -1);
            return info;
        }
        info.put("status", 1);
        info.put("rent", rent);
        BusCustomer customer = customerDao.selectById(rent.getCustomerIdentity());
        info.put("customer", customer);
        BusCar car = carDao.selectById(rent.getCarNumber());
        info.put("car", car);
        return info;
    }

    @Override
    public IPage<BusRent> sysAll(Integer page, Integer limit) {
        return rentDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusRent>()
                        .orderByDesc("created"));
    }

    @Override
    public IPage<BusRent> sysSearch(Integer page, Integer limit, Integer status, String type, String keyword) {
        return rentDao.selectPage(
                new Page<>(page, limit),
                new QueryWrapper<BusRent>()
                        .and(true, i -> i
                                .eq(status != 2, "rent_status", status)
                                .like(type, keyword))
                        .orderByDesc("created"));
    }

}
