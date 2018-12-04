package com.ytj.ssm.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
@Data
@TableName("tb_student")
public class StudentModel extends Model<StudentModel>{
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String studentNo;
	private String name;
	private String sex;
	private Integer age;
	private Integer status;
	private String profession;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
