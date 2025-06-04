package com.reliccollider.hengqimall.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.reliccollider.hengqimall.back.user.UserReturn;
import com.reliccollider.hengqimall.bean.User;
import com.reliccollider.hengqimall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserReturn getUsers(User user){
        String username=user.getUsername();
        List<User> users;
        if(username==null){
            users=userMapper.selectList(null);
            return new UserReturn(true,200,"查询成功！",users);
        } else{
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.like(User::getUsername, username);
            users=userMapper.selectList(wrapper);
            return new UserReturn(true,200,"查询成功！",users);
        }
    }

    public UserReturn deleteUsers(User user){
        userMapper.deleteById(user.getId());
        return new UserReturn(true,200,"删除成功！",null);
    }

    public UserReturn updateUsers(User user){
        userMapper.deleteById(user.getId());
        userMapper.insert(user);
        List<User> users=new ArrayList<>();
        users.add(user);
        return new UserReturn(true,200,"更新成功！",users);
    }
}
