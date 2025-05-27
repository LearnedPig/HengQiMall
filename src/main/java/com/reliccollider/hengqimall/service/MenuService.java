package com.reliccollider.hengqimall.service;

import com.reliccollider.hengqimall.back.onlode.OnLodeReturn;
import com.reliccollider.hengqimall.bean.MainMenu;
import com.reliccollider.hengqimall.bean.SubMenu;
import com.reliccollider.hengqimall.mapper.MainMenuMapper;
import com.reliccollider.hengqimall.mapper.SubMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MainMenuMapper mainMenuMapper;
    @Autowired
    private SubMenuMapper subMenuMapper;

    public OnLodeReturn OnLode(){
        List<MainMenu> mainMenus=mainMenuMapper.selectList(null);
        List<SubMenu> subMenus=subMenuMapper.selectList(null);
        for (MainMenu main:mainMenus) {
            List<SubMenu> children=new ArrayList<>();
            for (SubMenu sub:subMenus) {
                if (sub.getMid()==main.getId()) {
                    children.add(sub);
                }
            }
            main.setSubMenus(children);
        }
        if(!mainMenus.isEmpty()){
            return new OnLodeReturn(true,200,"加载菜单成功！",mainMenus);
        } else{
            return new OnLodeReturn(false,400,"加载菜单失败！",null);
        }
    }
}
