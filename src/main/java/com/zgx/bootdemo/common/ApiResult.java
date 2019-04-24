package com.zgx.bootdemo.common;

/**
 * @author zhouguixing
 * @date 2019/4/24 14:54
 * @description 统一返回格式
 */
public class ApiResult {
    private int code;
    private String message;
    private Object value;

    private ApiResult() {

    }

    public static ApiResult valueOf(Object body) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ErrorCode.SUCCESS.getCode());
        apiResult.setMessage(ErrorCode.SUCCESS.getMsg());
        apiResult.setValue(body);
        return apiResult;
    }

    public static ApiResult errorOf(ErrorCode errorCode, String message) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(errorCode.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ApiResult(int code, String message, Object value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }
}
