package com.synco.kava.util;

import lombok.Data;
import org.springframework.data.domain.Page;

/**
 * @Author:wangshuai
 * @Date:2019/1/26
 */

@Data
public class AppPage<T> {

    /** 页码*/
    private Integer pageNum;

    /** 页长*/
    private Integer pageSize;

    /** 总记录*/
    private Integer totalNum;

    /** 总页数*/
    private Integer totalPages;

    /** 数据信息*/
    private T data;

    public AppPage(Page page, Integer totalNum, Integer totalPages, T data) {
        this.pageNum = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.totalNum = totalNum;
        this.totalPages = totalPages;
        this.data = data;
    }
}

