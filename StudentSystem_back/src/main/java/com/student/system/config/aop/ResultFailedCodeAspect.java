package com.student.system.config.aop;

import com.student.system.model.constant.HttpStatusCode;
import com.student.system.model.vo.response.ResultVO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ResultFailedCodeAspect {
    @Pointcut("execution(public com.student.system.model.vo.response.ResultVO " +
            "com.student.system.controller..*.*(..))")
    public void controllerResult() {
    }

    @AfterReturning(value = "controllerResult()", returning = "result")
    public Object afterReturning(ResultVO result) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //请求成功
        if (requestAttributes == null) {
            return result;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        //回应信息
        if (response == null) {
            return result;
        }

        if (result.getCode() == ResultVO.FAIL) {
            response.setStatus(HttpStatusCode.NOT_ACCEPTABLE);
        }

        return result;
    }
}
