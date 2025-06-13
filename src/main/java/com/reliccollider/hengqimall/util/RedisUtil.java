package com.reliccollider.hengqimall.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

import static com.reliccollider.hengqimall.util.SystemConstants.*;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 存储验证码（带过期时间）
     * @param email token
     * @param code  验证码
     * @param expire 过期时间（秒）
     */
    public void setCode(String email, String code, long expire) {
        String key = Redis_User + Redis_email + email;
        redisTemplate.opsForValue().set(key, code, expire, TimeUnit.MINUTES);
    }

    /**
     * 获取验证码
     * @param email 手机号
     * @return 验证码（不存在返回 null）
     */
    public String getCode(String email) {
        String key = Redis_User + Redis_email + email;
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除验证码
     * @param email 手机号
     */
    public void deleteCode(String email) {
        String key = Redis_User + Redis_email + email;
        redisTemplate.delete(key);
    }

    /**
     * 检查是否允许发送验证码（防刷）
     * @param email 手机号
     * @return true=允许发送，false=需等待
     */
    public boolean allowSendCode(String email) {
        String key = Redis_User + Redis_email + email;
        return !redisTemplate.hasKey(key);
    }
}
