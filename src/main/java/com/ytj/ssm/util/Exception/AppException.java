package com.ytj.ssm.util.Exception;

/**
 * @Author: amin
 * @Date: 2018/12/4 20:17
 * @Description: 异常封装
 */
public class AppException extends RuntimeException{
    private Integer code;

    private String message;

    public AppException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
