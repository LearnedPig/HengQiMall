package com.reliccollider.hengqimall.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("subMenu")
public class SubMenu {
    private Integer id;
    private String title;
    private String path;
    private int mid;

    public SubMenu() {
    }

    public SubMenu(String title, String path, int mid) {
        this.title = title;
        this.path = path;
        this.mid = mid;
    }
}
