package com.synco.kava.service.impl;

import com.synco.kava.repository.CourseRepository;
import com.synco.kava.service.CourseService;
import com.synco.kava.util.AppPage;
import com.synco.kava.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public AppPage<CourseVO> findChapterList(PageRequest page, Long categoryId, String keyword) {
        return null;
    }
}

