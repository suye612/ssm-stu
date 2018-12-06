package com.ytj.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;
import com.ytj.ssm.util.DateUtil;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import com.ytj.ssm.util.Exception.AppException;
import com.ytj.ssm.util.Exception.BizExceptionEnum;

/**
 * 学生信息控制器
 *
 * @author amin
 * @date 2018/12/4
 */
@Controller
public class StudentController {

	@Resource
	private IStudentService studentService;
	/**
	 * @Description 分页查询全部信息 动态模糊查询
	 * @Param 
	 * @return 
	 **/
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<StudentModel> queryAll( @RequestBody JSONObject data) {
		Integer page = data.getInteger("page");
		Integer pageSize = data.getInteger("pageSize");
		StudentModel student = JSONObject.toJavaObject(data, StudentModel.class);
		//查询全部
		PageInfo<StudentModel>  pageInfo = studentService.queryAll(page,pageSize,student);
		System.out.println(pageInfo);
		return 	pageInfo;
	}
	/**
	 * @Description 新增学生信息
	 * @Param 
	 * @return 
	 **/
	@RequestMapping(value = "/insertStudent",method = RequestMethod.POST)
	@ResponseBody
	public Object insertStudent(@RequestBody JSONObject data){
		StudentModel studentModel = JSONObject.toJavaObject(data, StudentModel.class);
		studentModel.setStatus(Status.ENABLE);
		String stuNo = getStudentNo();
		studentModel.setStudentNo(stuNo);
		System.out.println(studentModel);
		boolean flag = studentService.insert(studentModel);
		if (flag) {
			return BizExceptionEnum.SUCCESS_TIP;
		} else {
			throw new AppException(BizExceptionEnum.INSERT_ERROR);
		}
	}
	/**
	 * @Description 查询一条学生信息
	 * @Param
	 * @return
	 **/
	@RequestMapping("/getStudent")
	@ResponseBody
	public StudentModel getStudent( Integer id ){
		return studentService.selectById(id);
	}
	/**
	 * @Description 修改学生信息
	 * @Param
	 * @return
	 **/
	@RequestMapping("/updateStudent")
	@ResponseBody
	public Object updateStudent(@RequestBody JSONObject data){
		StudentModel studentModel = JSONObject.toJavaObject(data, StudentModel.class);
		if (ToolUtil.isOneEmpty(studentModel,studentModel.getId())) {
			throw new AppException(BizExceptionEnum.REQUEST_ERROR);
		}
		boolean flag = studentService.updateById(studentModel);
		if (flag) {
			return  BizExceptionEnum.SUCCESS_TIP;
		} else {
			throw new AppException(BizExceptionEnum.UPDATE_ERROR);
		}
	}
	/**
	 * @Description 删除一条学生信息
	 * @Param
	 * @return
	 **/
	@RequestMapping("/deleteStudent")
	@ResponseBody
	public Object deleteStudent(Integer[] ids){
		if (ToolUtil.isOneEmpty(ids,ids.length)) {
			throw new AppException(BizExceptionEnum.REQUEST_ERROR);
		}
		List<StudentModel> list = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			StudentModel studentModel = new StudentModel();
			studentModel.setId(ids[i]);
			studentModel.setStatus(Status.DISABLED);
			list.add(studentModel);
		}
		boolean flag = studentService.updateBatchById(list,ids.length);
		if (flag) {
			return BizExceptionEnum.SUCCESS_TIP;
		} else {
			throw new AppException(BizExceptionEnum.DELETE_ERROR);
		}
	}

	/**
	 * @Description 生成学号
	 * @Param 
	 * @return 
	 **/
	public String getStudentNo(){
		String stuNo = null;
		stuNo = DateUtil.formatDate(new Date(), "yyyy");
		return stuNo;
	}
}
