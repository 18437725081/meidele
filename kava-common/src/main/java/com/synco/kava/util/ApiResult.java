package com.synco.kava.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author:wangshuai
 * @Date:2019/1/26
 */

public enum  ApiResult {

    SUCCESS(20000, "响应成功"),

    FAIL(40000, "系统异常"),
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

