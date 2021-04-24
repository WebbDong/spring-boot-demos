package com.webbdong.springboot.redis.cache.web.handler;

import com.webbdong.springboot.redis.cache.model.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局默认异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object defaultExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error(e.getMessage(), e);
        return ResponseVo.builder()
                .code(500)
                .msg("service error")
                .build();
    }

}
