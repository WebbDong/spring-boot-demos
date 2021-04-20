package com.webbdong.springboot.cache.web.util;

import com.webbdong.springboot.cache.model.vo.ResponseVo;

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
