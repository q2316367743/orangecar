package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.BusCustomer;

/**
 * @Author Esion
 * @Date 2020/9/23 21:21
 * @Version 1.0
 */
public interface CustomerService {

    /**
     * 查询全部客户，根据添加日期
     * */
    IPage<BusCustomer> queryCustomers(Integer page, Integer limit);
    /**
     * 查询客户根据条件，并分页
     * @param page 页码
     * @param limit 每页数目
     * @param type 查询的类型
     * @param keyword 查询的字段
     * */
    IPage<BusCustomer> queryByCustomer(Integer page, Integer limit, String type, String keyword);
    /**
     * 根据身份证号查询一个用户
     * */
    BusCustomer queryOne(String identity);
    /**
     * 增加一个客户
     * @param operator 操作人员
     * @param customer 客户信息
     * */
    int addCustomer(String operator, BusCustomer customer);
    /**
     * 更新客户信息
     * @param customer 客户信息
     * */
    int updateCustomer(BusCustomer customer);
    /**
     * 删除一个客户信息
     * @param id 客户ID
     * */
    int deleteCustomer(String identity);

}
