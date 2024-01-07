package com.student.system.config.themis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.system.manager.LoginStatusManager;
import com.student.system.model.bo.LoginStatusBO;
import com.student.system.model.constant.HttpStatusCode;
import com.student.system.model.vo.response.ResultVO;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;

@Component
public class ThemisInterceptor implements HandlerInterceptor {
    private final PermissionScanner scanner;
    private final LoginStatusManager loginStatusManager;
    private final ObjectMapper objectMapper;

    public ThemisInterceptor(PermissionScanner scanner, LoginStatusManager loginStatusManager, ObjectMapper objectMapper) {
        this.scanner = scanner;
        this.loginStatusManager = loginStatusManager;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //登录拦截器
    	if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        
        Permission permission = scanner.scan(method);
        if (!permission.getNeedLogin() || permission.getUserType().equals(0)) {
            return true;
        }

        LoginStatusBO loginStatus = loginStatusManager.getLoginStatus(request.getSession());
        if (!loginStatus.getLoggedIn()) {
            noLogin(response);
            return false;
        }
        if (!loginStatus.getUserType().equals(permission.getUserType())) {
            errorRole(response);
            return false;
        }
        return true;
    }

    private void noLogin(HttpServletResponse response) {
        response.setStatus(HttpStatusCode.UNAUTHORIZED);
        ResultVO resultVO = new ResultVO(ResultVO.NO_LOGIN, "您没有登录", null);
        sendResult(resultVO, response);
    }

    private void errorRole(HttpServletResponse response) {
        response.setStatus(HttpStatusCode.FORBIDDEN);
        ResultVO resultVO = new ResultVO(ResultVO.ERROR_ROLE, "您的角色错误", null);
        sendResult(resultVO, response);
    }

    private void sendResult(ResultVO result, HttpServletResponse response) {
        response.setCharacterEncoding("UTF8");
        response.setContentType("application/json");

        try (Writer writer = response.getWriter()) {
            writer.write(objectMapper.writeValueAsString(result));
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
