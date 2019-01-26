package com.synco.kava.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author:wangshuai
 * @Date:2019/1/25
 */

@Data
@Entity
@Table(name = "o_activation_code")
public class ActivationCode extends BaseEntity {

    private static final long serialVersionUID = 3054123103273212840L;

    /**
     * 激活码对应课程
     */
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    /**
     * 激活码数量
     */
    private Integer codeNum;

    /**
     * 邀请码渠道
     */
    private String activationChannel;

    /**
     * 过期时间
     */
    private String expireTime;

    /**
     * 生效时间
     */
    private String createTime;

    /**
     * 激活码状态
     */
    private Boolean status = false;

    /**
     * 激活码使用状态
     */
    private Boolean used = false;

}

