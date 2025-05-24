package com.reliccollider.hengqimall.security;

import com.reliccollider.hengqimall.bean.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtToken {
    private final Key SECRET_KEY;

    public JwtToken(@Value("${jwt.secret}") String secret) {
        SECRET_KEY = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
    public String createToken(User user, int type) {

        return Jwts.builder()
                .claim("user", user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000*24))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public User getName(String token) {
        return getClaims(token).get("user", User.class);
    }
    public Date getExpiration(String token) {
        return getClaims(token).getExpiration();
    }
    public boolean isTokenValid(String token) {
        try {
            Date expiration = getExpiration(token);
            return expiration.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    public String getToken(String authorization){
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new SecurityException("token不存在或格式错误！");
        }
        return authorization.substring(7);
    }
}
