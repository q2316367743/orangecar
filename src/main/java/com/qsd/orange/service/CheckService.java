package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.BusCheck;

/**
 * @Author Esion
 * @Date 2020/9/26 15:39
 * @Version 1.0
 */
public interface CheckService {

    /**
     * 汽车入库
     * @param id 出租单号
     * @param problem 存在的问题
     * @param compensate 赔偿金额
     * @param description 问题描述
     * @param operator 操作员
     * */
    int add(String id, String problem, Double compensate, String description, String operator);
    /**
     * 查询全部检查单
     * @param page 页码
     * @param limit 每页数目
     * */
    IPage<BusCheck> all(Integer page, Integer limit);
    /**
     * 查询一个检查单
     * @param id 出租单号
     * */
    BusCheck search(String id);

}
