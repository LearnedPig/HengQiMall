package com.reliccollider.hengqimall.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("mainMenu")
public class MainMenu {
    private int id;
    private String title;
    private String path;
    @TableField(exist = false)
    private List<SubMenu>  subMenus;

    public MainMenu() {
    }

    public MainMenu(String title, String path, List<SubMenu> subMenus) {
        this.title = title;
        this.path = path;
        this.subMenus = subMenus;
    }
}
