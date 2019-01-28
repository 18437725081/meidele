package com.synco.kava.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:wangshuai
 * @date:2019/1/28
 */

@Data
@Entity
@Table(name = "o_message")
public class Message extends BaseEntity{

    /** 消息标题*/
    private String msgTitle;

    /** 消息内容*/
    private String message;
}

