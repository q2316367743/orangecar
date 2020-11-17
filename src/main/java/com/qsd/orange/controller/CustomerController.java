package com.qsd.orange.controller;

import com.qsd.orange.po.BusCustomer;
import com.qsd.orange.service.CustomerService;
import com.qsd.orange.global.R;
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
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return R.success().page(customerService.queryCustomers(page, limit));
    }

    @GetMapping("search/identity")
    public R searchByIdentity(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword
    ){
        return R.success().page(customerService.queryByCustomer(page, limit, "identity", keyword));
    }

    @GetMapping("search/name")
    public R searchByName(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword
    ){
        return R.success().page(customerService.queryByCustomer(page, limit, "name", keyword));
    }

    @GetMapping("search/one/identity")
    public R searchOneIdentity(String identity){
        return R.success().data("item", customerService.queryOne(identity));
    }

    @PostMapping("add")
    public R add(@Valid BusCustomer customer, Authentication authentication){
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        return R.choose(customerService.addCustomer(username, customer) > 0);
    }

    @PostMapping("update")
    public R update(@Valid BusCustomer customer){
        return R.choose(customerService.updateCustomer(customer) > 0);
    }

}
