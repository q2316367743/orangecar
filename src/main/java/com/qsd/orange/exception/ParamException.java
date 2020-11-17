package com.qsd.orange.exception;

import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Esion
 * @Date 2020/9/26 10:44
 * @Version 1.0
 */
@RestControllerAdvice
public class ParamException {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R missingServletRequestParameterException(MissingServletRequestParameterException e){
        return R.error(HttpResult.PARAM_LACK);
    }

}
