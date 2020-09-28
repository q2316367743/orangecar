package com.qsd.orange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qsd.orange.po.SysAnnouncement;

/**
 * @Author Esion
 * @Date 2020/9/28 22:45
 * @Version 1.0
 */
public interface AnnouncementService {

    IPage<SysAnnouncement> all(Integer page, Integer limit);

}
