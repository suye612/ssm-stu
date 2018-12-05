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
    private  String chinese;
    private  String math;
    private  String english;
    private  String art;
    private  String music;
    private  String history;
    @TableField("student_id")
    private  Integer studentId;
    
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
