package com.crm_system.springbootback.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.crm_system.springbootback.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    public String getToken(Employee employee) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(employee.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(employee.getPassword()));
        return token;
    }
}