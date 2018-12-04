package com.ytj.ssm.service;

import com.baomidou.mybatisplus.service.IService;
import com.ytj.ssm.model.StudentModel;

public interface IStudentService extends IService<StudentModel> {
	public StudentModel studentByName(String name);

    Object queryAll(Integer page, Integer pageSize, StudentModel student);
}
