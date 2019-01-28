package com.synco.kava.controller;

import com.synco.kava.service.IndexService;
import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.IndexVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:wangshuai
 * @Date:2019/1/28
 */

@Api(tags = "首页模块")
@RestController
@RequestMapping(value = "/api/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexController {

    @Autowired
    private IndexService indexService;

    @ApiOperation(value = "banner图", response = String.class)
    @GetMapping
    public ResponseData<List<String>> showIndex() {
        return ResponseData.ok(null);
    }
}

