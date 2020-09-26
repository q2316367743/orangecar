package com.qsd.orange.vo;

import com.qsd.orange.enums.HttpResult;

import java.io.Serializable;

/**
 * @Author Esion
 * @Date 2020/9/23 19:00
 * @Version 1.0
 */
public class BaseVo implements Serializable {

    private Integer code;
    private String message;

    public BaseVo() {
    }

    public BaseVo(HttpResult result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
