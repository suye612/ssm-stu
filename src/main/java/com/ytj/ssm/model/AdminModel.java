package com.ytj.ssm.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("tb_admin")
public class AdminModel {
	private Integer id;
	private String username;
	private String tel;
	private String idcard;
	private Integer status;
	private Integer sex;
}
