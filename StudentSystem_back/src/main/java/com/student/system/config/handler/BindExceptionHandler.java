package com.student.system.config.handler;

import com.student.system.model.constant.HttpStatusCode;
import com.student.system.model.vo.response.ParameterErrorVO;
import com.student.system.model.vo.response.ResultVO;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//controller增强器
@RestControllerAdvice
public class BindExceptionHandler {
	//全局异常捕捉处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVO handleBindException(MethodArgumentNotValidException ex, HttpServletResponse response) {
        List<ParameterErrorVO> errorVOList = new ArrayList<>();

        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        for (ObjectError error : errorList) {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorVOList.add(new ParameterErrorVO(fieldName, message));
        }

        errorVOList.sort(Comparator.comparing(ParameterErrorVO::getFieldName));
        String message = "请求参数无效";
        if (errorVOList.size() > 0) {
            ParameterErrorVO firstError = errorVOList.get(0);
            message += ": " + firstError.getFieldName() + "-" + firstError.getMessage();
        }

        response.setStatus(HttpStatusCode.BAD_REQUEST);
        return new ResultVO(ResultVO.INVALID_PARAMETER, message, errorVOList);
    }
}
