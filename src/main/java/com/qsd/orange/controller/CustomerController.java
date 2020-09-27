package com.qsd.orange.controller;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.BusCustomer;
import com.qsd.orange.service.CustomerService;
import com.qsd.orange.vo.BaseVo;
import com.qsd.orange.vo.DataVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Esion
 * @Date 2020/9/24 7:48
 * @Version 1.0
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public PageVo<BusCustomer> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        IPage<BusCustomer> customers = customerService.queryCustomers(page, limit);
        return new PageVo<>(HttpResult.SUCCESS, customers);
    }

    @GetMapping("search/identity")
    public PageVo<BusCustomer> searchByIdentity(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword
    ){
        IPage<BusCustomer> customers = customerService.queryByCustomer(page, limit, "identity", keyword);
        return new PageVo<>(HttpResult.SUCCESS, customers);
    }

    @GetMapping("search/name")
    public PageVo<BusCustomer> searchByName(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword
    ){
        IPage<BusCustomer> customers = customerService.queryByCustomer(page, limit, "name", keyword);
        return new PageVo<>(HttpResult.SUCCESS, customers);
    }

    @GetMapping("search/one/identity")
    public DataVo<BusCustomer> searchOneIdentity(String identity){
        BusCustomer customer = customerService.queryOne(identity);
        return new DataVo<>(customer != null ? HttpResult.SUCCESS : HttpResult.NOT_FOUND, customer);
    }

    @PostMapping("add")
    public BaseVo add(@Valid BusCustomer customer, Authentication authentication){
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        int insert = customerService.addCustomer(username, customer);
        return new BaseVo(insert > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

    @PostMapping("update")
    public BaseVo update(@Valid BusCustomer customer){
        return new BaseVo(customerService.updateCustomer(customer) > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

}
