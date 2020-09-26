package com.qsd.orange.security;

import cn.hutool.core.date.DateException;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.vo.BaseVo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author Esion
 * @Date 2020/9/23 19:31
 * @Version 1.0
 */
@ControllerAdvice
public class LoginException {

    @ExceptionHandler(UsernameNotFoundException.class)
    public BaseVo usernameNotFoundException(){
        return new BaseVo(HttpResult.USERNAME_OR_PASSWORD_ERROR);
    }

}
