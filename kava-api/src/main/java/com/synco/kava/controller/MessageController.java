package com.synco.kava.controller;

import com.synco.kava.entity.Message;
import com.synco.kava.util.AppPage;
import com.synco.kava.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author:wangshuai
 * @date:2019/1/28
 */

@Api(tags = "消息模快")
@RestController
@RequestMapping(value = "/api/message", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageController {

    @ApiOperation(value = "消息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(value = "页长", name = "pageSize", paramType = "query", dataType = "Integer")
    })
    @GetMapping
    public ResponseData<AppPage<Message>> list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseData.ok();
    }

    @ApiOperation(value = "一键已读")
    @GetMapping("/read_all")
    public ResponseData<Object> readAll() {
        return ResponseData.ok();
    }

    @ApiOperation(value = "消息详情", response = Message.class)
    @GetMapping("/{id}")
    public ResponseData<Message> msgDetail(@PathVariable Long id) {
        Message message = new Message();
        return ResponseData.ok(message);
    }
}

