package com.qsd.orange.controller;

import com.qsd.orange.global.R;
import com.qsd.orange.po.SysAnnouncement;
import com.qsd.orange.service.AnnouncementService;
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
    public R add(@Valid SysAnnouncement announcement, Authentication authentication){
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        return R.choose(announcementService.add(announcement, username) > 0);
    }

    @PostMapping("update")
    public R update(SysAnnouncement announcement){
        return R.choose(announcementService.update(announcement) > 0);
    }

}
