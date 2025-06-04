package com.reliccollider.hengqimall.back.Menu;

import com.reliccollider.hengqimall.bean.MainMenu;
import lombok.Data;

import java.util.List;
@Data
public class MenuReturn {
    /*
     * 1. 200 请求成功
     * 2. 400 请求参数失败
     * 3. 401 未登录
     * 4. 403 权限不足
     * 5. 404 资源不存在
     * 6. 500 服务器内部错误
     */
    private Boolean success;
    private int code;
    private String message;
    private MenuReturnData data;

    public MenuReturn() {
    }

    public MenuReturn(Boolean success, int code, String message, List<MainMenu> mainMenu) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = new MenuReturnData(mainMenu);
    }
}
