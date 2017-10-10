package com.jastyle.fullstack.model.entity.response;

/**
 * author jastyle
 * description:
 * date 2017/9/26  下午3:26
 */

public class ResultResponse<T> {
    public String message;
    public T data;
    public ResultResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
