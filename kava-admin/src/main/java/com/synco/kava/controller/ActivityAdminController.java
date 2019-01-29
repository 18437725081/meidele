package com.synco.kava.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :wangshuai
 * @date: 2019/1/29
 */

@Api(tags = "活动模块")
@RestController
@RequestMapping(value = "/admin/activity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ActivityAdminController {
}

