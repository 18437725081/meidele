package com.synco.kava.repository;

import com.synco.kava.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:wangshuai
 * @Date:2019/1/25
 */

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

