package com.synco.kava.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangshuai
 * @date 2019/01/28
 */

@Data
@Entity
@Table(name = "o_admin")
public class Admin extends BaseEntity{

    private static final long serialVersionUID = -8017911349417291337L;

    /** 用户名*/
    private String username;

    /** 密码*/
    private String password;

    /** 手机号*/
    private String phone;
}

