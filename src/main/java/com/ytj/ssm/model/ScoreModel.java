package com.ytj.ssm.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
@TableName("tb_score")
public class ScoreModel extends Model<ScoreModel>{
	@TableId(value = "id", type = IdType.AUTO)
    private  Integer id;
    private  Double chinese;
    private  Double math;
    private  Double english;
    private  Double art;
    private  Double music;
    private  Double history;
    @TableField("student_id")
    private  Integer studentId;
    
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
