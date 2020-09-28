package com.qsd.orange.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsd.orange.po.SysAnnouncement;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Esion
 * @Date 2020/9/28 22:48
 * @Version 1.0
 */
@Mapper
public interface AnnouncementDao extends BaseMapper<SysAnnouncement> {
}
