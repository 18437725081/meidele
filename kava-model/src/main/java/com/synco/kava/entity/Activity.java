package com.synco.kava.entity;

import com.synco.kava.enums.ActivityStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 活动
 * @author :wangshuai
 * @date :2019/1/24
 */

@Data
@Entity
@Table(name = "o_course_activity")
public class Activity extends BaseEntity {

    private static final long serialVersionUID = -3227789938805237533L;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动图片
     */
    private String imgUrl;

    /**
     * 活动时间
     */
    private String activityTime;

    /**
     * 活动参与人数
     */
    private Integer participantSum;

    /**
     * 活动地址
     */
    private String activityAddress;

    /**
     * 活动的状态
     */
    private ActivityStatus status;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String contactPhone;
}

