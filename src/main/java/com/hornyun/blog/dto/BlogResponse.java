package com.hornyun.blog.dto;

import lombok.Data;

/**
 * @author hornyun
 */
@Data
public final class BlogResponse<T> {
    private static final String FAILURE = "500";
    private static final String SUCCESS = "200";
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAILURE_MESSAGE = "failure";


    /**
     * code of
     */
    private String code;

    private T data;

    private String message;

    private boolean success;

    private BlogResponse(String code, T data, String message,boolean success) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public static <T>BlogResponse<T> success(T data){
        return new BlogResponse<>(SUCCESS, data, SUCCESS_MESSAGE,true);
    }

    public static <T> BlogResponse<T> success() {
        return success(null);
    }

    public static <T>BlogResponse<T> failure(T data){
        return new BlogResponse<>(FAILURE, data, FAILURE_MESSAGE,false);
    }

    public static <T> BlogResponse<T> failure() {
        return failure(null);
    }
    public static <T> BlogResponse<T> failureMessage(String message) {
        return new BlogResponse<>(FAILURE, null, message,false);
    }

}
