package com.crm_system.springbootback.tool;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class Authentication implements HandlerInterceptor {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserToken.class)) {
            UserToken userToken = method.getAnnotation(UserToken.class);
            if (userToken.required()) {
                // 执行认证
                if (token == null) {
                    ResultUtil.fail("无token", null);
//                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId = null;

                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                Employee employee = employeeService.findEmployById(Integer.parseInt(userId));
                User user = userService.findUserById(Integer.parseInt(userId));
                if (employee == null && user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                else if (employee != null && user == null) {
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(employee.getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        throw new RuntimeException("401");
                    }
                    return true;
                } else {
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        throw new RuntimeException("401");
                    }
                    return true;
                }
            }
        }
        return true;
    }
}