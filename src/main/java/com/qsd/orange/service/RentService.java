package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.BusRent;

/**
 * @Author Esion
 * @Date 2020/9/25 16:50
 * @Version 1.0
 */
public interface RentService {

    /**
     * 增加一张出租单
     * 首先检查车辆状态，再进行增加
     * -2：车辆未找到；-1：车辆已被出租；0：客户未查到；1：成功
     * @param identity 用户身份证
     * @param number 车牌号
     * @param username 操作员
     * @return 返回完整出租单？还是只是结果？
     * */
    int add(String identity, String number, String returnTime, String username);
    /**
     * 查询全部的出租单
     * @param page 页码
     * @param limit 每页数目
     * */
    IPage<BusRent> all(Integer page, Integer limit);
    IPage<BusRent> search(Integer page, Integer limit, String type, String keyword);

}
