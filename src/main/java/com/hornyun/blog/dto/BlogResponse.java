package com.hornyun.blog.dto;

/**
 * @author hornyun
 */
public class BlogResponse<T> {
    private static final String FAILURE = "500";
    private static final String SUCCESS = "200";
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAILURE_MESSAGE = "failure";



    private String code;

    private T data;

    private String message;


    public BlogResponse() {
    }

    public BlogResponse(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T>BlogResponse<T> success(T data){
        return new BlogResponse<>(SUCCESS, data, SUCCESS_MESSAGE);
    }

    public static <T> BlogResponse<T> success() {
        return success(null);
    }

    public static <T>BlogResponse<T> failure(T data){
        return new BlogResponse<>(FAILURE, data, FAILURE_MESSAGE);
    }

    public static <T> BlogResponse<T> failure() {
        return failure(null);
    }

}
