package com.synco.kava.entity;

import com.synco.kava.enums.ShelfState;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 课程分类
 * @Author:wangshuai
 * @Date:2019/1/24
 */

@Data
@Entity
@Table(name = "o_category")
public class CourseCategory extends BaseEntity {

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类icon
     */
    private String icon;

    /**
     * 上下架状态
     */
    private ShelfState state;

    /** 上架时间*/
    private Date shelfTime;

    /** 课程列表*/
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();
}

