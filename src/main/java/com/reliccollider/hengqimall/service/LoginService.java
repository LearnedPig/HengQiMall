package com.reliccollider.hengqimall.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reliccollider.hengqimall.bean.User;
import com.reliccollider.hengqimall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    private LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

    public String login(User user){
        wrapper.eq(User::getUsername, user.getUsername());
        User sql_use=userMapper.selectOne(wrapper);
        if(sql_use!=null){
            if(user.getPassword().equals(sql_use.getPassword())){
                return "登陆成功！";
            } else{
                return "密码错误！";
            }
        } else{
            return "用户不存在！";
        }
    }

    public String register(User user){
        wrapper.eq(User::getUsername, user.getUsername());
        User sql_use=userMapper.selectOne(wrapper);
        if(sql_use==null){
            userMapper.insert(user);
            return "注册成功！";
        } else{
            return "用户已存在！";
        }
    }
}
