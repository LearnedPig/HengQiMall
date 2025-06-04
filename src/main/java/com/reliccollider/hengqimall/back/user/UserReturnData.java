package com.reliccollider.hengqimall.back.user;

import com.reliccollider.hengqimall.bean.User;
import lombok.Data;

import java.util.List;
@Data
public class UserReturnData {
    private List<User> user;
    private int total;

    public UserReturnData() {
    }

    public UserReturnData(List<User> user) {
        this.user = user;
        this.total = 0;
        if(user!=null){
            this.total=user.size();
        }
    }
}
