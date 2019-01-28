package com.synco.kava.vo;

import com.synco.kava.entity.Activity;
import com.synco.kava.enums.ActivityStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :wangshuai
 * @date :2019/1/28
 */

@ApiModel
@Data
public class ActivityVO {

    @ApiModelProperty(value = "活动名称", name = "activityName")
    private String activityName;

    @ApiModelProperty(value = "活动状态", name = "status")
    private String status;

    @ApiModelProperty(value = "报名人数", name = "signUpNum")
    private Integer signUpNum;

    @ApiModelProperty(value = "活动截止时间", name = "expireTime")
    private String expireTime;

    @ApiModelProperty(value = "活动地点", name = "address")
    private String address;

    @ApiModelProperty(value = "活动图片", name = "imgUrl")
    private String imgUrl;

    public ActivityVO(Activity activity) {
        this.activityName = activity.getActivityName();
        this.address = activity.getActivityAddress();
        this.expireTime = activity.getActivityTime();
        this.imgUrl = activity.getImgUrl();
        this.signUpNum = activity.getParticipantSum();
        if (activity.getStatus().equals(ActivityStatus.ENROLMENT)) {
            this.status = ActivityStatus.ENROLMENT.getMsg();
        } else if (activity.getStatus().equals(ActivityStatus.FINISHED)) {
            this.status = ActivityStatus.FINISHED.getMsg();
        } else {
            this.status = ActivityStatus.SIGN_UP_END.getMsg();
        }
    }
}

