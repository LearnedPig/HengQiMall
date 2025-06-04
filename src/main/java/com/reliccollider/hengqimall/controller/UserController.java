package com.reliccollider.hengqimall.controller;

import com.reliccollider.hengqimall.back.user.UserReturn;
import com.reliccollider.hengqimall.bean.User;
import com.reliccollider.hengqimall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public UserReturn getUsers(@RequestBody User user){
        return userService.getUsers(user);
    }

    @RequestMapping("/delete")
    public UserReturn deleteUsers(@RequestBody User user){
        return userService.deleteUsers(user);
    }

    @RequestMapping("/update")
    public UserReturn updateUsers(@RequestBody User user){
        return userService.updateUsers(user);
    }
}
