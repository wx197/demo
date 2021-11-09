package com.example.demo.conf.Security;

import com.example.demo.common.StatusCodeEnum;
import com.example.demo.util.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * <p>
 * Security 结果处理配置
 * </p>
 *  @author blackcat
 *  @since 2020-07-21
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, StatusCodeEnum.ACCESS_DENIED, null);
    }

}

