package com.synco.kava.controller;

import com.synco.kava.entity.Course;
import com.synco.kava.service.CourseService;
import com.synco.kava.util.AppPage;
import com.synco.kava.util.ResponseData;
import com.synco.kava.vo.CourseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@Api(tags = "课程模块")
@RequestMapping(value = "/api/course", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "课程章节列表", response = CourseVO.class, notes = "分类ID为空，查询最新课程")
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", dataType = "Integer", example = "1"),
            @ApiImplicitParam(value = "页长", name = "pageSize", paramType = "query", dataType = "Integer", example = "10"),
            @ApiImplicitParam(value = "分类ID", name = "categoryId", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(value = "搜索的关键字", name = "keyword", paramType = "query", dataType = "String", example = "牙医")
    })
    public ResponseData<AppPage<CourseVO>> courseChapters(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, Long categoryId, String keyword) {
        PageRequest page = PageRequest.of(pageNum - 1, pageSize);
        return ResponseData.ok(courseService.findChapterList(page, categoryId, keyword));
    }

    @ApiOperation(value = "课程详情", response = CourseVO.class)
    @GetMapping("/{id}")
    public ResponseData<CourseVO> courseDetail(@PathVariable Long id) {
        CourseVO courseVO = new CourseVO();
        return ResponseData.ok(courseVO);
    }

    @ApiOperation(value = "联想词列表", response = String.class)
    @ApiImplicitParam(value = "输入的搜索词", name = "keyword", required = true, paramType = "query", dataType = "String")
    @GetMapping("/association_words")
    public ResponseData<List<String>> associationWords(String keyword) {
        List<String> list = new ArrayList<>();
        return ResponseData.ok(list);
    }

    @ApiOperation(value = "查看更多课程", response = CourseVO.class)
    @GetMapping("/more")
    public ResponseData<List<CourseVO>> moreCourse() {
        List<CourseVO> list = new ArrayList<>();
        return ResponseData.ok(list);
    }
}

