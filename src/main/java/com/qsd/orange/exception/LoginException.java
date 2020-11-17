package com.qsd.orange.exception;

import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
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
    public R usernameNotFoundException(){
        return R.error(HttpResult.USERNAME_OR_PASSWORD_ERROR);
    }

}
