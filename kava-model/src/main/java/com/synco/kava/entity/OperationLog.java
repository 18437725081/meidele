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
@Table(name = "o_operation_log")
public class OperationLog extends BaseEntity {

    /**
     * 操作时间
     */
    private String operationTime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作的方法
     */
    private String method;

    /**
     * 操作的IP
     */
    private String ip;

    /**
     * 操作参数
     */
    private String[] params;
}

