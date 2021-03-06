package com.ytj.ssm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ytj.ssm.model.StudentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao extends BaseMapper<StudentModel> {
	public StudentModel studentByName(@Param("name") String name);

	 Integer queryAllCount(StudentModel student);

	List<StudentModel> queryAll(@Param("page") Integer page, @Param("pageSize") Integer pageSize, StudentModel student);
}
