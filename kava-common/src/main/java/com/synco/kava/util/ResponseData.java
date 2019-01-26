package com.synco.kava.util;

import lombok.Data;

/**
 * @Author:wangshuai
 * @Date:2019/1/26
 */

@Data
public class ResponseData<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应的信息
     */
    private String msg;

    /**
     * 响应的数据信息
     */
    private T data;

    /**
     * 响应成功
     * @param <T> 泛型
     * @return 状态码: 20000，状态信息:响应成功
     */
    public static <T> ResponseData<T> ok() {
        return new ResponseData<>(ApiResult.SUCCESS);
    }

    /**
     * 返回请求结果
     * @param data 返回得到数据信息
     * @param <T> 泛型
     * @return 状态码：20000， 状态信息：响应成功， 数据：结果数据
     */
    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>(ApiResult.SUCCESS, data);
    }

    /**
     * 响应失败
     * @param <T> 泛型
     * @return 状态码：40000， 状态信息：系统异常
     */
    public static <T> ResponseData<T> error() {
        return new ResponseData<>(ApiResult.FAIL);
    }

    /**
     * 响应失败
     * @param apiResult 状态码和状态信息的响应对象
     * @param <T> 泛型
     * @return 响应对象对应的状态码和状态信息
     */
    public static <T> ResponseData<T> error(ApiResult apiResult) {
        return new ResponseData<>(apiResult);
    }

    /**
     * 自定义异常信息
     * @param apiResult 状态码和状态信息的响应对象
     * @param errorMsg 自定义的异常信息
     * @param <T> 泛型
     * @return 状态码和自定义的异常信息
     */
    public static <T> ResponseData<T> error(ApiResult apiResult, String errorMsg) {
        return new ResponseData<>(apiResult, errorMsg);
    }

    private ResponseData(ApiResult apiResult) {
        this.code = apiResult.getCode();
        this.msg = apiResult.getMsg();
    }

    private ResponseData(ApiResult apiResult, T data) {
        this.code = apiResult.getCode();
        this.msg = apiResult.getMsg();
        this.data = data;
    }

    private ResponseData(ApiResult apiresult, String errorMsg) {
        this.code = apiresult.getCode();
        this.msg = errorMsg;
    }
}

