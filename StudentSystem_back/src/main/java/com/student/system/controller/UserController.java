package com.student.system.controller;

import com.student.system.model.vo.request.LoginVO;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //登录界面
    @PostMapping("/login")
    public ResultVO login(@Validated @RequestBody LoginVO loginVO) {
        String username = loginVO.getUsername();
        String password = loginVO.getPassword();
        Integer userType = loginVO.getUserType();
        return service.login(username, password, userType);
    }

    //返回登录身份信息
    @RequestMapping("/login/status")
    public ResultVO getLoginStatus() {
        return service.getLoginStatus();
    }

    //注销
    @RequestMapping("/logout")
    public ResultVO logout() {
        return service.logout();
    }
}
