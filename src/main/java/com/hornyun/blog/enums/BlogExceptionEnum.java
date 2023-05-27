package com.hornyun.blog.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum BlogExceptionEnum {

    SHIRO_EXCEPTION("1000", "权限异常"),
    SERVER_ERROR_EXCEPTION("8000", "服务器异常"),
    ;

    private String code;
    private String message;

    BlogExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
