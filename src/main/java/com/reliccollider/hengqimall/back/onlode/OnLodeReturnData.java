package com.reliccollider.hengqimall.back.onlode;

import com.reliccollider.hengqimall.bean.MainMenu;
import lombok.Data;

import java.util.List;

@Data
public class OnLodeReturnData {
    private List<MainMenu> mainMenu;

    public OnLodeReturnData() {
    }

    public OnLodeReturnData(List<MainMenu> mainMenu) {
        this.mainMenu = mainMenu;
    }
}
