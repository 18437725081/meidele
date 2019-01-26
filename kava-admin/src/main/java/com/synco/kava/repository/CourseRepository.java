package com.synco.kava.repository;

import com.synco.kava.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:wangshuai
 * @Date:2019/1/25
 */

public interface CourseRepository extends JpaRepository<Course, Long> {
}

