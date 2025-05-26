package com.reliccollider.hengqimall.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("mainMenu")
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu>  subMenus;
}
