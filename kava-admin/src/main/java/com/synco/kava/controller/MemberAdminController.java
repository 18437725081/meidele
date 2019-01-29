package com.synco.kava.controller;

import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.MemberVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/admin/members", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MemberAdminController {

    @ApiOperation(value = "用户列表", response = MemberVO.class)
    @GetMapping
    public ResponseData<MemberVO> list() {
        return ResponseData.ok();
    }

    @ApiOperation(value = "用户详情", response = MemberVO.class)
    @GetMapping("/{memberId}")
    public ResponseData<MemberVO> detail(@PathVariable Long memberId) {
        MemberVO memberVO = new MemberVO();
        return ResponseData.ok(memberVO);
    }

    @ApiOperation(value = "导出用户列表")
    @ApiImplicitParam(value = "搜索的关键字", name = "keyword", paramType = "body", dataType = "String")
    @PostMapping
    public ResponseData exportMembers(@RequestBody String keyword) {
        return ResponseData.ok();
    }
}

