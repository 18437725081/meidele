package com.synco.kava.controller;

import com.synco.kava.param.CourseParam;
import com.synco.kava.util.ApiResult;
import com.synco.kava.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author :wangshuai
 * @date :2019/1/28
 */
@Api(tags = "课程学习模块")
@RestController
@RequestMapping(value = "/api/study", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudyCourseController {

    @ApiOperation(value = "激活课程")
    @ApiImplicitParam(value = "激活课程参数信息", name = "param", paramType = "body", required = true, dataType = "CourseParam")
    @PostMapping
    public ResponseData<Object> activation(@RequestBody CourseParam param, @Valid BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseData.error(ApiResult.PARAM_ERROR);
        }
        return ResponseData.ok();
    }

    @ApiOperation(value = "查看是否激活课程", response = Boolean.class)
    @ApiImplicitParam(value = "查看课程是否激活", name = "param", paramType = "body", required = true, dataType = "CourseParam")
    @GetMapping
    public ResponseData<Boolean> isActivation(@RequestBody CourseParam param, @Valid BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseData.error(ApiResult.PARAM_ERROR);
        }
        return ResponseData.ok(true);
    }
}
