package com.reliccollider.hengqimall.back;

import com.reliccollider.hengqimall.bean.User;
import lombok.Data;

@Data
public class ReturnData {
    private String token;
    private User userInfo;

    public ReturnData() {
    }

    public ReturnData(String token, User user) {
        this.token = token;
        this.userInfo = user;
    }
}
