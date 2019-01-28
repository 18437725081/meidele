package com.synco.kava.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@Data
@ApiModel
public class IndexVO {

    @ApiModelProperty(value = "banner图", name = "banners")
    private List<String> banners;

    @ApiModelProperty(value = "分类名称", name = "categoryList")
    private List<String> categoryList;
}

