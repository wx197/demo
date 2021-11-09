package com.example.demo.common;

/**
 * <p>
 *
 * </p>
 *
 * @author wx227336
 * @Date 2021/11/4 9:49
 * @Version 1.0
 */
public interface IStatusCode {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();
}
