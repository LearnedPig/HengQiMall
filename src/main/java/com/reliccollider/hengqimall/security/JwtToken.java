package com.reliccollider.hengqimall.security;

import com.reliccollider.hengqimall.bean.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtToken {

    private final Key SECRET_KEY;

    // 从配置文件中读取密钥
    public JwtToken(@Value("${jwt.secret}") String secret) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // 创建 token，携带用户 id 和用户名，以及用户类型
    public String createToken(User user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("type", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 24)) // 1天有效期
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // 获取 Claims 负载
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 获取过期时间
    public Date getExpiration(String token) {
        return getClaims(token).getExpiration();
    }

    // 检查 token 是否有效（是否过期）
    public boolean isTokenValid(String token) {
        try {
            return getExpiration(token).after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 获取用户 ID
    public Long getUserId(String token) {
        try {
            return getClaims(token).get("id", Long.class);
        } catch (Exception e) {
            return null;
        }
    }

    // 获取用户名
    public String getUsername(String token) {
        try {
            return getClaims(token).get("username", String.class);
        } catch (Exception e) {
            return null;
        }
    }

    // 获取用户类型
    public Integer getUserType(String token) {
        try {
            return getClaims(token).get("type", Integer.class);
        } catch (Exception e) {
            return null;
        }
    }
}
