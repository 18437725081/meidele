package com.synco.kava.controller;

import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.IndexVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangshuai
 * @date : 2019/1/29
 */

@Api(tags = "首页模块")
@RestController
@RequestMapping(value = "/admin/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexController {

    @ApiOperation(value = "首页数据展示", response = IndexVO.class)
    @GetMapping
    public ResponseData<IndexVO> showIndex() {
        return ResponseData.ok();
    }
}

