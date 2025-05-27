package com.reliccollider.hengqimall.back.login;

import com.reliccollider.hengqimall.bean.User;
import lombok.Data;

@Data
public class LoginReturn {
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
    private LoginReturnData data;
    public LoginReturn(Boolean _success, int _code, String _message, String token, User user){
        success=_success;
        code=_code;
        message=_message;
        data=new LoginReturnData(token,user);
    }
}
