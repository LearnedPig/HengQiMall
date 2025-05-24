package com.reliccollider.hengqimall.security;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class JwtTokenValidator {
    @Autowired
    private JwtToken jwtToken;

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String authorization = request.getHeader("Authorization");
        String token=jwtToken.getToken(authorization);
        if (!jwtToken.isTokenValid(token)) {
            throw new SecurityException("token无效或已过期！");
        }
        return joinPoint.proceed();
    }
}
