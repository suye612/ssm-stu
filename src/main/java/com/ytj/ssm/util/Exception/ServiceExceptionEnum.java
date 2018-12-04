package com.ytj.ssm.util.Exception;

/**
 * @Author: amin
 * @Date: 2018/12/4 20:10
 * @Description: 异常抽象接口
 */
public interface ServiceExceptionEnum {
    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
