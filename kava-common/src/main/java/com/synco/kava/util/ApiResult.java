package com.synco.kava.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author :wangshuai
 * @date :2019/1/26
 */

public enum  ApiResult {

    /** 响应成功*/
    SUCCESS(20000, "响应成功"),

    /** 响应失败*/
    FAIL(40000, "系统异常"),

    /** 请求参数信息错误*/
    PARAM_ERROR(40001, "请求参数有误"),
    ;


    /** 状态码*/
    @Setter
    @Getter
    private Integer code;

    /** 状态信息*/
    @Setter
    @Getter
    private String msg;

    ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

