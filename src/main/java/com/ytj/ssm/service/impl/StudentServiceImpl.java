package com.ytj.ssm.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.StudentDao;
import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.model.ScoreModel;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IScoreService;
import com.ytj.ssm.service.IStudentService;
import com.ytj.ssm.util.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao,StudentModel > implements IStudentService{

	@Autowired
	private IScoreService scoreService;

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

	@Override
	public String selectLastStudent() {
		return baseMapper.selectLastStudent();
	}

	@Override
	public boolean insertStudent(StudentModel studentModel) {
		Integer row = baseMapper.insert(studentModel);
		boolean flag = insertScore(studentModel.getId());
		return flag && (row>0);
	}
	private boolean insertScore(Integer stuId){
		ScoreModel scoreModel = new ScoreModel();
		scoreModel.setStudentId(stuId);
		scoreModel.setArt(getScore());
		scoreModel.setChinese(getScore());
		scoreModel.setEnglish(getScore());
		scoreModel.setHistory(getScore());
		scoreModel.setMath(getScore());
		scoreModel.setMusic(getScore());
		return scoreService.insert(scoreModel);
	}
	private Double getScore(){
		String num = NumUtil.keep2Point(new Random().nextInt(10000) * 0.01);
		return Double.parseDouble(num);
	}
}
