package com.reliccollider.hengqimall.back.Menu;

import com.reliccollider.hengqimall.bean.MainMenu;
import lombok.Data;

import java.util.List;

@Data
public class MenuReturnData {
    private List<MainMenu> mainMenu;

    public MenuReturnData() {
    }

    public MenuReturnData(List<MainMenu> mainMenu) {
        this.mainMenu = mainMenu;
    }
}
