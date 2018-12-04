package com.ytj.ssm.model;

import lombok.Data;

@Data
public class AdminModel {
	private Integer id;
	private String username;
	private String password;
	private String tel;
	private String idcard;
	private Integer status;
	private Integer sex;
}
