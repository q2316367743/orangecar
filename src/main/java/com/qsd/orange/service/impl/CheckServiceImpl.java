package com.qsd.orange.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.qsd.orange.dao.CarDao;
import com.qsd.orange.dao.CheckDao;
import com.qsd.orange.dao.RentDao;
import com.qsd.orange.po.BusCar;
import com.qsd.orange.po.BusCheck;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @Author Esion
 * @Date 2020/9/26 15:44
 * @Version 1.0
 */
@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckDao checkDao;
    @Autowired
    private RentDao rentDao;
    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public int add(String id, String problem, Double compensate, String description, String operator) {
        String number = rentDao.selectCarNumber(id);
        if(StrUtil.isEmpty(number)){
            return 0;
        }
        BusCheck check = new BusCheck();
        Timestamp returnTime = DateUtil.date().toTimestamp();
        check.setId("JC_" + DateUtil.date().toString("yyyyMMdd") + "_" + RandomUtil.randomNumbers(4));
        check.setCheckDate(returnTime);
        check.setCompensate(compensate);
        check.setDescription(description);
        check.setProblem(problem);
        check.setRentId(id);
        check.setOperator(operator);
        int insert = checkDao.insert(check);
        if (insert > 0){
            //修改出租单状态
            BusRent rent = new BusRent();
            rent.setId(id);
            rent.setRentStatus(1);
            rent.setRealTime(returnTime);
            rentDao.updateById(rent);
            //修改车辆状态
            BusCar car = new BusCar();
            car.setNumber(number);
            car.setStatus(0);
            carDao.updateById(car);
        }
        return insert;
    }

}
