package com.synco.kava.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author :wangshuai
 * @date :2019/1/24
 */

public enum  ActivityStatus {

    /** 活动报名中*/
    ENROLMENT(0, "活动报名中"),

    /** 报名结束*/
    SIGN_UP_END(1, "报名结束"),

    /** 活动结束*/
    FINISHED(2, "活动结束"),
    ;
    @Setter
    @Getter
    private String msg;

    @Setter
    @Getter
    private Integer code;

    ActivityStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

