package com.example.demo.common;

import lombok.Data;

/**
 * <p>
 *  通用的 API 接口封装
 * </p>
 *
 * @author wx227336
 * @Date 2021/11/4 9:43
 * @Version 1.0
 */
@Data
public class ApiResponse<T> {
    private static final long serialVersionUID = 8993485788201922830L;
    private Integer code;

    private String message;

    private T data;

    private Long total;

    /**
     * 无参构造
     */
    public ApiResponse() {
    }
    /**
     * 全参构造
     * @param code  状态码
     * @param message  返回内容
     * @param data  返回数据
     * @param total
     */
    public ApiResponse(Integer code, String message, T data, Long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    private ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse ofSuccess(Object data, long total) {
        return new ApiResponse(StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage(), data, total);
    }
    /**
     * 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     * @return ApiResponse
     */
    public static ApiResponse of(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * 构造一个成功且不带数据的API返回
     *
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * 构造一个成功且带数据的API返回
     *
     * @param data 返回数据
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(StatusCodeEnum.SUCCESS, data);
    }

    /**
     * 构造一个成功且自定义消息的API返回
     *
     * @param message 返回内容
     * @return ApiResponse
     */
    public static ApiResponse ofMessage(String message) {
        return of(StatusCodeEnum.SUCCESS.getCode(), message, null);
    }

    /**
     * 构造一个有状态的API返回
     *
     * @param status 状态 {@link StatusCodeEnum}
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(StatusCodeEnum status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link StatusCodeEnum}
     * @param data   返回数据
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(StatusCodeEnum status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * 构造一个异常的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }
}
