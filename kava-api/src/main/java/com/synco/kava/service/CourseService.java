package com.synco.kava.service;

import com.synco.kava.util.AppPage;
import com.synco.kava.vo.CourseVO;
import org.springframework.data.domain.PageRequest;

/**
 * 课程模块
 * @Author:wangshuai
 * @Date:2019/1/28
 */

public interface CourseService {

    /**
     * 分页查询课程列表
     * @param page 分页对象
     * @param categoryId 分类ID
     * @param keyword 搜索的关键词
     * @return 分页的章节信息
     */
    AppPage<CourseVO> findChapterList(PageRequest page, Long categoryId, String keyword);
}

