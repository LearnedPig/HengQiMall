package com.reliccollider.hengqimall.controller;

import com.reliccollider.hengqimall.back.Return;
import com.reliccollider.hengqimall.bean.User;
import com.reliccollider.hengqimall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public Return login(@RequestBody User user){
        return loginService.login(user);
    }

    @RequestMapping("/register")
    public Return register(@RequestBody User user){
        return loginService.register(user);
    }
}
