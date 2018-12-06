package com.ytj.ssm.util.Exception;

/**
 * @Author: amin
 * @Date: 2018/12/4 20:10
 * @Description: 所有业务异常的枚举
 */
public enum BizExceptionEnum implements ServiceExceptionEnum{
    /**
     * 成功
     */
    SUCCESS_TIP(200,"操作成功!"),
    /**
     *新增失败!
     **/
    INSERT_ERROR(400,"新增失败!"),
    /**
     *修改失败!
     **/
    UPDATE_ERROR(400,"修改失败!"),
    /**
     *注册失败!
     **/
    REGISTER_ERROR(400,"注册失败!"),
    /**
     *删除失败!
     **/
    DELETE_ERROR(400,"删除失败!"),
    /**
     *登录失败!
     **/
    LONGIN_ERROR(400,"登录失败!"),
    /**
     *请求异常!
     **/
    REQUEST_ERROR(400,"请求异常!"),
    /**
     *数据库没有该资源!
     **/
    NO_DATA_ERROR(400,"数据库没有该资源!")
    ;
    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private Integer code;

    private String message;
    @Override
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
