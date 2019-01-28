package com.synco.kava.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@ApiModel
public class CourseParam {

    @ApiModelProperty(value = "课程激活码", name = "activationNo")
    private String activationNo;

    @ApiModelProperty(value = "课程编号", name = "courseId", required = true)
    private String courseId;

    @ApiModelProperty(value = "会员ID", name = "memberId", required = true)
    private String memberId;

}

