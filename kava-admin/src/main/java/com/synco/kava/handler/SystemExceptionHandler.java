package com.synco.kava.handler;

import com.synco.kava.exception.BusinessException;
import com.synco.kava.util.ApiResult;
import com.synco.kava.util.ResponseData;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 异常拦截处理
 * @author: cangcang
 * @create: 2018-10-26 10:29
 **/
@ControllerAdvice
@ResponseBody
public class SystemExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseData<String> exceptionHandler(Exception e) {

        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            return ResponseData.error(ex.getApiResult(), ex.getErrorMsg());
        }

        else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return ResponseData.error(ApiResult.FAIL, msg);
        }
        return ResponseData.error(ApiResult.FAIL, "系统异常");
    }

}
