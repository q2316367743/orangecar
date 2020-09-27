package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.BusRent;

import java.util.Map;

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
    /**
     * 根据类型搜索出租单
     * @param page 页码
     * @param limit 每页数目
     * @param type 类型
     * @param keyword 关键字
     * */
    IPage<BusRent> search(Integer page, Integer limit, String type, String keyword);
    /**
     * 修改归还日期
     * @param id 出租单号
     * @param returnTime 新归还日期
     * @return 0：出租单未找到；-1：新归还日期少于开始日期；-2：新归还日期少于今天；1：成功；-3：参数错误
     * */
    int updateReturnTime(String id, String returnTime);
    /**
     * 查询出租单详情、客户详情、车辆详情
     * @param id 出租单号
     * */
    Map<String, Object> info(String id);
    /**
     * 查询全部的出租单
     * @param page 页码
     * @param limit 每页数目
     * */
    IPage<BusRent> sysAll(Integer page, Integer limit);
    /**
     * 根据类型搜索出租单
     * @param page 页码
     * @param limit 每页数目
     * @param status 出租状态
     * @param type 类型
     * @param keyword 关键字
     * */
    IPage<BusRent> sysSearch(Integer page, Integer limit, Integer status, String type, String keyword);

}
