package com.synco.kava.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : wangshuai
 * @date : 2019/1/29
 */

@ApiModel
@Data
public class IndexVO implements Serializable {

    private static final long serialVersionUID = -8616432935625573923L;

    @ApiModelProperty(value = "总激活人数", name = "activationNum")
    private Integer activationNum;
}

