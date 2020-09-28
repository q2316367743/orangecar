package com.qsd.orange.exception;

import com.baomidou.mybatisplus.extension.api.R;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.vo.BaseVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.util.List;

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
    public BaseVo validation(){
        return new BaseVo(HttpResult.PARAM_ERROR);
    }

}
