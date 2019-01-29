package com.synco.kava.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@Data
@ApiModel
public class ActivationVO {

    @ApiModelProperty(value = "邀请码渠道", name = "channelName")
    private String channelName;

    @ApiModelProperty(value = "邀请码数量", name = "totalNum")
    private Integer totalNum;

    @ApiModelProperty(value = "使用数量", name = "usedNum")
    private Integer usedNum;

    @ApiModelProperty(value = "对应的课程", name = "courseName")
    private String courseName;

    @ApiModelProperty(value  = "生效时间", name = "effectiveTime")
    private String effectiveTime;

    @ApiModelProperty(value = "失效时间", name = "invalidTime")
    private String invalidTime;

    @ApiModelProperty(value = "状态", name = "status")
    private String status;
}

