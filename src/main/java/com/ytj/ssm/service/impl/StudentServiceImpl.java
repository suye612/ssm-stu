package com.ytj.ssm.service.impl;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.StudentDao;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao,StudentModel > implements IStudentService{
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
