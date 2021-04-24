package com.webbdong.springboot.redis.cache.web.util;

import com.webbdong.springboot.redis.cache.model.vo.ResponseVo;

public interface ResponseVoUtils {

    static ResponseVo success() {
        return ResponseVo.builder()
                .code(200)
                .msg("success")
                .build();
    }

    static ResponseVo success(Object data) {
        return ResponseVo.builder()
                .code(200)
                .msg("success")
                .data(data)
                .build();
    }

}
