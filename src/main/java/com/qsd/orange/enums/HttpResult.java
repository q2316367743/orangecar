package com.qsd.orange.enums;

/**
 * @Author Esion
 * @Date 2020/9/23 19:01
 * @Version 1.0
 */
public enum HttpResult {

    SUCCESS(200, "成功"),
    NOT_FOUND(404, "资源未找到"),
    SERVER_ERROR(500, "服务器错误"),
    USERNAME_OR_PASSWORD_ERROR(501, "用户名或密码错误"),
    CAR_IS_RENTING(502, "车辆已被出租"),
    USER_INFO_ERROR(503, "用户信息错误"),
    PARAM_ERROR(504, "参数类型错误");

    private Integer code;
    private String message;

    HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
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