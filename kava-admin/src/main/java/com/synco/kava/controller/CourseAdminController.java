package com.synco.kava.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@Api(value = "课程模块")
@RestController
@RequestMapping(value = "/admin/course", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CourseAdminController {
}

