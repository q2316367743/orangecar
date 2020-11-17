package com.qsd.orange.vo;

import java.io.Serializable;

/**
 * @Author Esion
 * @Date 2020/11/17 19:55
 * @Version 1.0
 */
public class RegionVo implements Serializable {

    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
