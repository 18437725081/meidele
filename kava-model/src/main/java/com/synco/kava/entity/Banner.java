package com.synco.kava.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author:wangshuai
 * @Date:2019/1/24
 */

@Data
@Entity
@Table(name = "o_banner")
public class Banner extends BaseEntity{

    /** 图片链接*/
    private String imageUrl;
}

