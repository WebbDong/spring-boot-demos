package com.webbdong.springboot.aop.config;

import com.webbdong.springboot.aop.interceptor.ControllerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Webb Dong
 * @date 2022-02-26 11:03 PM
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ControllerInterceptor controllerInterceptor() {
        return new ControllerInterceptor();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加授权拦截器
        registry.addInterceptor(controllerInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .maxAge(3600 * 24);
    }

}
