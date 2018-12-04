package com.ytj.ssm.service.impl;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.StudentDao;
import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao,StudentModel > implements IStudentService{

	@Override
	public StudentModel studentByName(String name) {
		StudentModel studentModel = baseMapper.studentByName(name);
		return studentModel;
	}

	@Override
	public PageInfo<StudentModel> queryAll(Integer page, Integer pageSize, StudentModel student) {
		//总记录数
		int totalCount = baseMapper.queryAllCount(student);
		PageInfo<StudentModel> pageInfo = new PageInfo(totalCount, page);
		pageInfo.setPageSize(pageSize);
		List<StudentModel> list =  baseMapper.queryAll(pageInfo.getStart(), pageSize, student);
		pageInfo.setList(list);
		return pageInfo ;
	}

}
