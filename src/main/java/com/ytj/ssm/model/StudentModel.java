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
	private int id;
	private String studentNo;
	private String name;
	private String sex;
	private int age;
	private String profession;
	private Integer status;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
