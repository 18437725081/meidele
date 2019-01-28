package com.synco.kava.vo;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@ApiModel
@Data
public class CategoryVO implements Serializable {

    @ApiModelProperty(value = "分类名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "分类ID", name = "id")
    private Long id;

    @ApiModelProperty(value = "激活数量", name = "usedNum")
    private Integer usedNum;

    @ApiModelProperty(value = "状态", name = "state")
    private String state;

    @ApiModelProperty(value = "上架时间", name = "shelfTime")
    @JSONField(format = DatePattern.NORM_DATETIME_PATTERN)
    private Date shelfTime;



}

