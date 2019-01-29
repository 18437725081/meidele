package com.synco.kava.controller;

import com.synco.kava.util.AppPage;
import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.ActivationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@Api(tags = "激活码模块")
@RestController
@RequestMapping(value = "/admin/activation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ActivationAdminController {

    @ApiOperation(value = "激活码列表", response = ActivationVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(value = "页长", name = "pageSize", paramType = "query", dataType = "Integer")
    })
    @GetMapping
    public ResponseData<AppPage<ActivationVO>> list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return ResponseData.ok();
    }

}

