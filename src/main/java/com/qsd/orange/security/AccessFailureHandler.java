package com.qsd.orange.security;

import cn.hutool.json.JSONUtil;
import com.qsd.orange.global.HttpResult;
import com.qsd.orange.global.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @Author Esion
 * @Date 2020/11/12 16:57
 * @Version 1.0
 */
@Component
public class AccessFailureHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        accessDeniedException.printStackTrace();
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.parseObj(R.error(HttpResult.UN_AUTHORIZED)).toJSONString(4));
    }
    
}
