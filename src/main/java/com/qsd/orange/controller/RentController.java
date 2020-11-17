package com.qsd.orange.controller;

import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
import com.qsd.orange.po.BusRent;
import com.qsd.orange.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public R add(String identity, String number, String returnTime, Authentication authentication){
        User users = (User)authentication.getPrincipal();
        String username = users.getUsername();
        int add = rentService.add(identity, number, returnTime, username);
        switch (add){
            case -1:
                return R.error(HttpResult.CAR_IS_RENTING);
            case 0:
                return R.error(HttpResult.USER_INFO_ERROR);
            case 1:
                return R.success();
            default:
                return R.error(HttpResult.SERVER_ERROR);
        }
    }

    @GetMapping("all")
    public R all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return R.success().page(rentService.all(page, limit));
    }

    @GetMapping("search")
    public R search(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit,
            String keyword,
            Integer type
    ){
        switch (type){
            case 0:
                return R.success().page(rentService.search(page, limit, "id", keyword));
            case 1:
                return R.success().page(rentService.search(page, limit, "customer_identity", keyword));
            case 2:
                return R.success().page(rentService.search(page, limit, "car_number", keyword));
            default:
                return R.error(HttpResult.PARAM_ERROR);
        }
    }

    @PostMapping("update/returnTime")
    public R update(String id, String returnTime){
        int i = rentService.updateReturnTime(id, returnTime);
        switch (i){
            case -3:
                return R.error(HttpResult.PARAM_ERROR);
            case -2:
            case -1:
                return R.error(HttpResult.DATE_ERROR);
            case 0:
                return R.error(HttpResult.NOT_FOUND);
            case 1:
                return R.success();
            default:
                return R.error(HttpResult.SERVER_ERROR);
        }
    }

    @GetMapping("info")
    public R info(String id){
        Map<String, Object> info = rentService.info(id);
        int status = (Integer) info.get("status");
        info.remove("status");
        switch (status){
            case -1:
                return R.error(HttpResult.CAR_IS_RETURN);
            case 0:
                return R.error(HttpResult.NOT_FOUND);
            default:
                return R.success().data(info);
        }

    }

}
