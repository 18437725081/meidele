package com.synco.kava.controller;

import com.synco.kava.entity.Member;
import com.synco.kava.param.CourseParam;
import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.CourseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:wangshuai
 * @date:2019/1/28
 */

@Api(tags = "会员模块")
@RestController
@RequestMapping(value = "/api/member", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MemberController {

    @ApiOperation(value = "我的详情", response = Member.class)
    @GetMapping("/{id}")
    public ResponseData<Member> myDetail(@PathVariable Long id) {
        return ResponseData.ok();
    }

    @ApiOperation(value = "购买课程的历史记录", response = CourseVO.class)
    @ApiImplicitParam(value = "历史记录时间段", name = "type", dataType = "Integer", paramType = "query",example = "1 表示更早 0: 一周内")
    @GetMapping("/history")
    public ResponseData<List<CourseVO>> historyList(Integer type) {
        return ResponseData.ok();
    }

    @ApiOperation(value = "收藏课程", response = Boolean.class)
    @ApiImplicitParam(value = "收藏课程的参数信息", name = "param", required = true, paramType = "body", dataType = "CourseParam")
    @PostMapping
    public ResponseData<Boolean> collectionCourse(@RequestBody CourseParam param) {
        return ResponseData.ok(true);
    }
}

