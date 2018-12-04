package com.ytj.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytj.ssm.model.StudentModel;

public interface StudentDao extends BaseMapper<StudentModel>{
	public StudentModel studentByName(String name);

	 Integer queryAllCount(StudentModel student);

	Object queryAll(Integer page, Integer pageSize, StudentModel student);
}
