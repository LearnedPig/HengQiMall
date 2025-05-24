package com.reliccollider.hengqimall.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@TableName("user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;

    public User() {

    }
    public User(String username, String password, String email, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }
}
