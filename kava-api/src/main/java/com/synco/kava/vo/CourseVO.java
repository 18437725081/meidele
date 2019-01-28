package com.synco.kava.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author  wangshuai
 * @date  2019/1/28
 */

@Data
@ApiModel
public class CourseVO implements Serializable {

    private static final long serialVersionUID = 6744662881488532008L;

    @ApiModelProperty(value = "课程名称", name = "courseName")
    @NotNull
    private String courseName;

    @ApiModelProperty(value = "视频链接", name = "videoUrl")
    private String videoUrl;

    @ApiModelProperty(value = "视频封面", name = "coverPage")
    private String coverPage;

    @ApiModelProperty(value = "课程描述", name = "courseDesc")
    private String courseDesc;

    @ApiModelProperty(value = "购买人数", name = "paidNum")
    private Integer paidNum;

    @ApiModelProperty(value = "课程观看数", name = "viewNum")
    private Integer viewNum;

    @ApiModelProperty(value = "学习次数", name = "studyNum")
    private Integer studyNum;

    @ApiModelProperty(value = "章节总数", name = "chapterNum")
    private Integer chapterNum;

    @ApiModelProperty(value = "章节ID", name = "parentId")
    private Long parentId;

    @ApiModelProperty(value = "上下架状态", name = "state")
    @NotNull
    private String state;

    @ApiModelProperty(value = "课程价格", name = "price")
    private BigDecimal price;
}

