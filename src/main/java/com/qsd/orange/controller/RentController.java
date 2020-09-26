package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import com.qsd.orange.vo.BaseVo;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Esion
 * @Date 2020/9/25 16:45
 * @Version 1.0
 */
@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping("add")
    public BaseVo add(String identity, String number, String returnTime, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        int add = rentService.add(identity, number, returnTime, username);
        switch (add){
            case -1:
                return new BaseVo(HttpResult.CAR_IS_RENTING);
            case 0:
                return new BaseVo(HttpResult.USER_INFO_ERROR);
            case 1:
                return new BaseVo(HttpResult.SUCCESS);
            default:
                return new BaseVo(HttpResult.SERVER_ERROR);
        }
    }

    @GetMapping("all")
    public PageVo<BusRent> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return new PageVo<>(HttpResult.SUCCESS, rentService.all(page, limit));
    }

    @GetMapping("search")
    public PageVo<BusRent> search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword,
            Integer type
    ){
        switch (type){
            case 0:
                return new PageVo<>(HttpResult.SUCCESS, rentService.search(page, limit, "id", keyword));
            case 1:
                return new PageVo<>(HttpResult.SUCCESS, rentService.search(page, limit, "customer_identity", keyword));
            case 2:
                return new PageVo<>(HttpResult.SUCCESS, rentService.search(page, limit, "car_number", keyword));
            default:
                return new PageVo<>(HttpResult.PARAM_ERROR);
        }
    }

}
