package com.ytj.ssm.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytj.ssm.dao.StudentDao;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<BaseMapper<StudentModel> , StudentModel> implements IStudentService{
	@Resource
	private StudentDao studentDao;

	@Override
	public StudentModel studentByName(String name) {
		StudentModel studentModel = studentDao.studentByName(name);
		return studentModel;
	}

	@Override
	public Object queryAll(Integer page, Integer pageSize, StudentModel student) {
		int count=studentDao.queryAllCount(student);
		//这里是分页





		return studentDao.queryAll( page,  pageSize,  student);
	}

}
