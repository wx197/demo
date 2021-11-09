package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.BaseException;
import com.example.demo.common.IStatusCode;
import com.example.demo.common.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author wx227336
 * @Date 2021/11/4 17:32
 * @Version 1.0
 */
@Slf4j
public class ResponseUtil {

    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param status   状态
     * @param data     返回数据
     */
    public static void renderJson(HttpServletResponse response, IStatusCode status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);


            response.getWriter()
                    .write(JSONObject.toJSONString(ApiResponse.ofStatus((StatusCodeEnum) status, data), false));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response  响应
     * @param exception 异常
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);


            response.getWriter()
                    .write(JSONObject.toJSONString(ApiResponse.ofException(exception), false));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }
}
