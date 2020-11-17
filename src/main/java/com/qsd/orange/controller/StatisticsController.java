package com.qsd.orange.controller;

import com.qsd.orange.dao.StatisticsDao;
import com.qsd.orange.global.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据统计
 * @Author Esion
 * @Date 2020/11/17 19:57
 * @Version 1.0
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsDao statisticsDao;

    @GetMapping("region")
    public R region(){
        return R.success().data("items", statisticsDao.getRegionVo());
    }

}
