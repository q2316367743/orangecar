package com.qsd.orange.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.dao.CustomerDao;
import com.qsd.orange.po.BusCustomer;
import com.qsd.orange.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Esion
 * @Date 2020/9/23 23:37
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public IPage<BusCustomer> queryCustomers(Integer page, Integer limit) {
        return customerDao.selectPage(new Page<>(page, limit), new QueryWrapper<BusCustomer>().orderByDesc(true, "created"));
    }

    @Override
    public IPage<BusCustomer> queryByCustomer(Integer page, Integer limit, String type, String keyword) {
        return customerDao.selectPage(new Page<>(page, limit), new QueryWrapper<BusCustomer>().like(true, type, keyword).orderByDesc(true, "created"));
    }

    @Override
    public BusCustomer queryOne(String identity) {
        return customerDao.selectOne(new QueryWrapper<BusCustomer>().eq("identity", identity));
    }

    @Override
    public int addCustomer(String operator, BusCustomer customer) {
        customer.setCreated(DateUtil.date().toTimestamp());
        customer.setOperator(operator);
        return customerDao.insert(customer);
    }

    @Override
    public int updateCustomer(BusCustomer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(String identity) {
        BusCustomer customer = new BusCustomer();
        customer.setIdentity(identity);
        customer.setExist(false);
        return customerDao.updateById(customer);
    }

}
