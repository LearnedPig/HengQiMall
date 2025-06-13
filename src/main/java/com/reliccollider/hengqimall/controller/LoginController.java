package com.reliccollider.hengqimall.controller;

import com.reliccollider.hengqimall.back.login.LoginReturn;
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
    public LoginReturn login(@RequestBody User user){
        return loginService.login(user);
    }

    @RequestMapping("/register")
    public LoginReturn register(@RequestBody User user){
        return loginService.register(user);
    }
    @RequestMapping("/registerCode")
    public LoginReturn register(String email){
        return loginService.registerCode(email);
    }
}
