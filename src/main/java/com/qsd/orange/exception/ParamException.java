package com.qsd.orange.exception;

import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.vo.BaseVo;
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
    public BaseVo missingServletRequestParameterException(MissingServletRequestParameterException e){
        return new BaseVo(HttpResult.PARAM_LACK);
    }

}
