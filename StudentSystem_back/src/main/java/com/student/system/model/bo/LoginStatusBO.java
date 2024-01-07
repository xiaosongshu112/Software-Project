package com.student.system.model.bo;

import com.student.system.model.constant.UserType;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginStatusBO implements Serializable {
    private Boolean loggedIn = false;
    private Integer userId;
    private String username;
    private Integer userType = UserType.NO;
    private Integer permission = 0;

    //返回登录信息
    public static LoginStatusBO fromAuthInfo(AuthInfoBO authInfo) {
        LoginStatusBO loginStatus = new LoginStatusBO();
        loginStatus.loggedIn = true;
        loginStatus.userId = authInfo.getId();
        loginStatus.username = authInfo.getUsername();
        loginStatus.userType = authInfo.getUserType();
        loginStatus.permission = authInfo.getPermission();

        return loginStatus;
    }
}
