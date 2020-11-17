package com.qsd.orange.exception;

import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.UnexpectedTypeException;

/**
 * @Author Esion
 * @Date 2020/9/27 12:39
 * @Version 1.0
 */
@RestControllerAdvice
public class ValidationException {

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            UnexpectedTypeException.class
    })
    public R validation(){
        return R.error(HttpResult.PARAM_ERROR);
    }

}
