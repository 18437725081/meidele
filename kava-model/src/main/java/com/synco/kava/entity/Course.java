package com.synco.kava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synco.kava.enums.ShelfState;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程
 *
 * @Author:wangshuai
 * @Date:2019/1/24
 */

@Data
@Entity
@Table(name = "o_course")
public class Course extends BaseEntity {

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 视频链接
     */
    private String videoUrl;

    /**
     * 视频封面
     */
    private String coverPage;

    /**
     * 课程描述
     */
    private String courseDesc;

    /**
     * 课程购买人数
     */
    private Integer paidNum = 0;

    /**
     * 课程观看数
     */
    private Integer viewNum = 0;

    /**
     * 学习次数
     */
    private Integer studyNum;

    /**
     * 该课程小节总数
     */
    private Integer chapterNum;

    /**
     * 课程父ID
     */
    private Long parentId;

    /**
     * 课程上下架状态
     */
    private ShelfState state;

    /**
     * 课程价格
     */
    private BigDecimal price;

    /**
     * 课程介绍图片
     */
    @ElementCollection
    @CollectionTable(name = "o_course_image", joinColumns = @JoinColumn(name = "imageId"))
    private List<String> images = new ArrayList<>();

    /**
     * 课程标签
     */
    private String courseTag;

    /**
     * 课程分类
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private CourseCategory category;

    /**
     * 收藏该课程的会员信息
     */
    @ManyToMany(mappedBy = "courses")
    private List<Member> members = new ArrayList<>();

    /**
     * 课程的激活码信息
     */
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActivationCode> codes;
}

