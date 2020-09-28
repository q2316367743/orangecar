package com.qsd.orange.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.dao.AnnouncementDao;
import com.qsd.orange.po.SysAnnouncement;
import com.qsd.orange.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Esion
 * @Date 2020/9/28 22:47
 * @Version 1.0
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public IPage<SysAnnouncement> all(Integer page, Integer limit) {
        return announcementDao.selectPage(new Page<>(page, limit), new QueryWrapper<SysAnnouncement>().orderByDesc("created"));
    }

}
