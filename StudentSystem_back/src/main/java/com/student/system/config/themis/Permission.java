package com.student.system.config.themis;

import com.student.system.model.constant.UserType;
import lombok.Data;

@Data
public class Permission {
    private Integer userType = UserType.NO;
    private Integer permission = 0;
    private Boolean needLogin = true;

    public Permission() {

    }

    public Permission(Integer userType) {
        this.userType = userType;
    }

    public Permission(Integer userType, Integer permission) {
        this.userType = userType;
        this.permission = permission;
    }

    public Permission(Boolean needLogin) {
        this.needLogin = needLogin;
    }
}
