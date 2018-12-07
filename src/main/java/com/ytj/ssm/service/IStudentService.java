package com.ytj.ssm.service;

import com.baomidou.mybatisplus.service.IService;
import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.model.StudentModel;

public interface IStudentService extends IService<StudentModel> {
	public StudentModel studentByName(String name);

    PageInfo<StudentModel> queryAll(Integer page, Integer pageSize, StudentModel student);

    String selectLastStudent();

    boolean insertStudent(StudentModel studentModel);
}
