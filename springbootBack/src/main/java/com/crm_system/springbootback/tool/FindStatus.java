package com.crm_system.springbootback.tool;

import com.auth0.jwt.JWT;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class FindStatus implements  HandlerInterceptor {
    static int status;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
//        status= JWT.decode(token).getAudience().get(0);
        return true;
    }

    public static int getStatus() {

        return status;
    }
}
