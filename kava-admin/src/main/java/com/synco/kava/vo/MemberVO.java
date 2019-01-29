package com.synco.kava.vo;

import cn.hutool.core.date.DatePattern;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@ApiModel
@Data
public class MemberVO implements Serializable {

    @ApiModelProperty(value = "会员昵称", name = "nickname")
    private String nickname;

    @ApiModelProperty(value = "会员图像",name = "headImg")
    private String headImg;

    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    @ApiModelProperty(value = "创建时间", name = "createDate")
    @JSONField(format = DatePattern.NORM_DATETIME_PATTERN)
    private Date createDate;
}

