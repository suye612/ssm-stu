package com.ytj.ssm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ytj.ssm.model.StudentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao extends BaseMapper<StudentModel> {
	public StudentModel studentByName(@Param("name") String name);

	 Integer queryAllCount(@Param("student")StudentModel student);

	List<StudentModel> queryAll(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
								@Param("student") StudentModel student);

    String selectLastStudent();
}
