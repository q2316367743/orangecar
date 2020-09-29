package com.qsd.orange.controller;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.po.SysAnnouncement;
import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.AnnouncementService;
import com.qsd.orange.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Esion
 * @Date 2020/9/29 10:53
 * @Version 1.0
 */
@RestController
@RequestMapping("system/announcement")
public class SystemAnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("add")
    public BaseVo add(@Valid SysAnnouncement announcement, Authentication authentication){
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        return new BaseVo(announcementService.add(announcement, username) > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

    @PostMapping("update")
    public BaseVo update(SysAnnouncement announcement){
        return new BaseVo(announcementService.update(announcement) > 0 ? HttpResult.SUCCESS : HttpResult.SERVER_ERROR);
    }

}
