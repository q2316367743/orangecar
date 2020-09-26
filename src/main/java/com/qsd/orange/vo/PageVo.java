package com.qsd.orange.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qsd.orange.enums.HttpResult;

import java.util.List;

/**
 * 分页视图
 * @Author Esion
 * @Date 2020/9/24 7:49
 * @Version 1.0
 */
public class PageVo<T> extends BaseVo {

    private List<T> record;
    private Long current;
    private Long total;

    public PageVo(HttpResult result){
        super(result);
    }

    public PageVo(HttpResult result, IPage<T> page){
        super(result);
        this.record = page.getRecords();
        this.current = page.getCurrent();
        this.total = page.getTotal();
    }

    public List<T> getRecord() {
        return record;
    }

    public void setRecord(List<T> record) {
        this.record = record;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
