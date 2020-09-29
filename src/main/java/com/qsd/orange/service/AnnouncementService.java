package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.SysAnnouncement;

/**
 * @Author Esion
 * @Date 2020/9/28 22:45
 * @Version 1.0
 */
public interface AnnouncementService {

    //查询全部公告
    IPage<SysAnnouncement> all(Integer page, Integer limit);
    //新增一条公告
    int add(SysAnnouncement announcement, String username);
    //更新一条公告
    int update(SysAnnouncement announcement);

}
