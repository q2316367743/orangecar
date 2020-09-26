package com.qsd.orange.security;

import cn.hutool.json.JSONUtil;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.vo.BaseVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Esion
 * @Date 2020/9/14 19:44
 * @Version 1.0
 */
@Controller
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(new BaseVo(HttpResult.USERNAME_OR_PASSWORD_ERROR)));
    }

}
