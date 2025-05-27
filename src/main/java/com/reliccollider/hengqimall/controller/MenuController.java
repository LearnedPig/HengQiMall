package com.reliccollider.hengqimall.controller;

import com.reliccollider.hengqimall.back.onlode.OnLodeReturn;
import com.reliccollider.hengqimall.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/menus")
    public OnLodeReturn login(){
        return menuService.OnLode();
    }
}
