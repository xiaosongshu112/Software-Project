package com.student.system.manager;

import com.student.system.model.bo.LoginStatusBO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

//登录身份组件
@Component
public class LoginStatusManager extends BaseManager {
    private static final String SESSION_USER_STATUS = "user_status";

    //设置登录身份
    public void setLoginStatus(HttpSession session, LoginStatusBO loginStatus) {
        session.setAttribute(SESSION_USER_STATUS, loginStatus);
    }

    //返回登录身份
    public LoginStatusBO getLoginStatus(HttpSession session) {
        LoginStatusBO loginStatus = (LoginStatusBO) session.getAttribute(SESSION_USER_STATUS);
        if (loginStatus == null) {
            loginStatus = new LoginStatusBO();
            setLoginStatus(session, loginStatus);
        }

        return loginStatus;
    }
}
