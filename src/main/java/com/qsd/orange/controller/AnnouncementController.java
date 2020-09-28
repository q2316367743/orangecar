package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.SysAnnouncement;
import com.qsd.orange.service.AnnouncementService;
import com.qsd.orange.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Esion
 * @Date 2020/9/28 22:42
 * @Version 1.0
 */
@RestController
@RequestMapping("announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("all")
    public PageVo<SysAnnouncement> all(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "9") Integer limit
    ){
        return new PageVo<>(HttpResult.SUCCESS, announcementService.all(page, limit));
    }

}
