package com.synco.kava.exception;

import com.synco.kava.util.ApiResult;
import lombok.Data;

/**
 * @Author:wangshuai
 * @Date:2019/1/26
 */

@Data
public class BusinessException extends RuntimeException{

    /** 异常的状态信息*/
    private ApiResult apiResult;

    /** 异常码*/
    private Integer code;

    /** 异常信息*/
    private String errorMsg;

    public BusinessException(ApiResult apiResult) {
        this.apiResult = apiResult;
        this.errorMsg = apiResult.getMsg();
    }

    public BusinessException(ApiResult apiResult, String errorMsg) {
        this.apiResult = apiResult;
        this.errorMsg = errorMsg;
    }
}

