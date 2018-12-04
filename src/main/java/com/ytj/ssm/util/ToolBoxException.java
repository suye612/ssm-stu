package com.ytj.ssm.util;

/**
 * 工具类初始化异常
 * @package  com.yrs.core.support.exception
 * @file     ToolBoxException.java
 * @author   
 * @date     2018年9月14日 下午4:07:14
 * @version  V 1.0
 */
public class ToolBoxException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public ToolBoxException(Throwable e) {
		super(e.getMessage(), e);
	}
	
	public ToolBoxException(String message) {
		super(message);
	}
	
	public ToolBoxException(String messageTemplate, Object... params) {
		super(StrKit.format(messageTemplate, params));
	}
	
	public ToolBoxException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public ToolBoxException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrKit.format(messageTemplate, params), throwable);
	}
}
