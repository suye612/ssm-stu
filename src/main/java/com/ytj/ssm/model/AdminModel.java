package com.ytj.ssm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_admin")
public class AdminModel extends Model<AdminModel>{
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String username;
	private String tel;
	private String idcard;
	private Integer status;
	private Integer sex;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
