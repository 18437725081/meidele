package com.synco.kava.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@ApiModel
@Data
public class CourseVO {

    @ApiModelProperty(value = "课程名称", name = "courseName")
    private String courseName;

    @ApiModelProperty(value = "课程分类名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "激活数量", name = "activationNum")
    private Integer activationNum;

    @ApiModelProperty(value = "状态", name = "state")
    private String state;

    @ApiModelProperty(value = "上架时间", name = "shelfTime")
    private String shelfTime;

}

