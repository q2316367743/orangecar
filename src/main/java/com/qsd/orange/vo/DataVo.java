package com.qsd.orange.vo;

import com.qsd.orange.enums.HttpResult;

/**
 * @Author Esion
 * @Date 2020/9/24 18:18
 * @Version 1.0
 */
public class DataVo<T> extends BaseVo {

    private T data;

    public DataVo() {
    }

    public DataVo(HttpResult result) {
        super(result);
    }

    public DataVo(HttpResult result, T data) {
        super(result);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
