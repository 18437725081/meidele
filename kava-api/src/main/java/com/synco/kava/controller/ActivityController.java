package com.synco.kava.controller;

import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.ActivityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@Api(tags = "活动模块")
@RestController
@RequestMapping(value = "/api/activity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ActivityController {

    @ApiOperation(value = "活动列表", response = ActivityVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(value = "页长", name = "pageSize", paramType = "query", dataType = "Integer")
    })
    @GetMapping
    public ResponseData<List<ActivityVO>> list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return ResponseData.ok();
    }

    @ApiOperation(value = "活动详情", response = ActivityVO.class)
    @GetMapping("/{id}")
    public ResponseData<ActivityVO> detail(@PathVariable Long id) {
        return ResponseData.ok();
    }

    @ApiOperation(value = "活动报名", response = Boolean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "活动编号", name = "activityId", required = true, dataType = "Long", paramType = "form"),
            @ApiImplicitParam(value = "用户openId", name = "openId", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping
    public ResponseData<Boolean> signUp(String openId, Long activityId) {
        return ResponseData.ok(true);
    }
}

