package com.student.system.service;

import com.student.system.manager.LoginStatusManager;
import com.student.system.manager.UserManager;
import com.student.system.model.bo.AuthInfoBO;
import com.student.system.model.bo.LoginStatusBO;
import com.student.system.model.constant.UserType;
import com.student.system.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

//用户服务
@Service
public class UserService extends BaseService {
    private final HttpSession session;
    private final UserManager manager;
    private final LoginStatusManager loginStatusManager;

    public UserService(HttpSession session, UserManager manager, LoginStatusManager loginStatusManager) {
        this.session = session;
        this.manager = manager;
        this.loginStatusManager = loginStatusManager;
    }

    public ResultVO login(String username, String password, Integer userType) {
    	//获取身份信息
        AuthInfoBO authInfo = manager.getAuthInfoByUsername(username, userType);
        if (authInfo == null) 
            return failedResult("用户不存在");
        if (!password.equals(authInfo.getPassword())) 
            return failedResult("密码错误");

        LoginStatusBO statusBO = LoginStatusBO.fromAuthInfo(authInfo);
        loginStatusManager.setLoginStatus(session, statusBO);

        return result(statusBO);
    }
    
    //返回登录身份
    public ResultVO getLoginStatus() {
        LoginStatusBO statusBO = loginStatusManager.getLoginStatus(session);
        return result(statusBO);
    }

    //注销
    public ResultVO logout() {
        loginStatusManager.setLoginStatus(session, null);
        return result("注销成功");
    }
}
