package com.synco.kava.controller;

import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangshuai
 * @date :2019/1/28
 */

@Api(tags = "课程分类模块")
@RestController
@RequestMapping(value = "/api/category", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CategoryController {

    @ApiOperation(value = "分类列表", response = CategoryVO.class)
    @GetMapping
    public ResponseData<CategoryVO> list() {
        return ResponseData.ok();
    }
}


