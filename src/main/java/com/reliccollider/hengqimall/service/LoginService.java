package com.reliccollider.hengqimall.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reliccollider.hengqimall.back.login.LoginReturn;
import com.reliccollider.hengqimall.bean.User;
import com.reliccollider.hengqimall.mapper.UserMapper;
import com.reliccollider.hengqimall.security.JwtToken;
import com.reliccollider.hengqimall.util.RedisUtil;
import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtToken jwtToken;
    @Autowired
    private RedisUtil redisUtil;

    public LoginReturn login(User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User sql_use=userMapper.selectOne(wrapper);
        if(sql_use!=null){
            if(user.getPassword().equals(sql_use.getPassword())){
                String token=jwtToken.createToken(sql_use);
                return new LoginReturn(true,200,"登陆成功！",token,sql_use);
            } else{
                return new LoginReturn(false,400,"账号密码错误！",null,null);
            }
        } else{
            return new LoginReturn(false,400,"账号不存在！",null,null);
        }
    }

    public LoginReturn register(User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User sql_use=userMapper.selectOne(wrapper);
        if(sql_use==null){
            user.setState(true);
            userMapper.insert(user);
            sql_use=userMapper.selectOne(wrapper);
            String token=jwtToken.createToken(sql_use);
            return new LoginReturn(true,200,"注册成功！",token,sql_use);
        } else{
            return new LoginReturn(true,400,"用户名已存在！",null,null);
        }
    }

    public LoginReturn registerCode(String email){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getEmail, email);
        User sql_use=userMapper.selectOne(wrapper);
        if(sql_use==null){
            int _code = ThreadLocalRandom.current().nextInt(100000, 1000000);
            String code = String.valueOf(_code);
            redisUtil.setCode(email,code,30L);
            return new LoginReturn(true,200,"发送成功！",code,null);
        } else{
            return new LoginReturn(true,400,"发送失败！！",null,null);
        }
    }
}
