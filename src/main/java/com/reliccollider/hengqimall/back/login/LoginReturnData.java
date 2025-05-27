package com.reliccollider.hengqimall.back.login;

import com.reliccollider.hengqimall.bean.User;
import lombok.Data;

@Data
public class LoginReturnData {
    private String token;
    private User userInfo;

    public LoginReturnData() {
    }

    public LoginReturnData(String token, User user) {
        this.token = token;
        this.userInfo = user;
    }
}
