package com.ytj.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.util.DateUtil;
import com.ytj.ssm.util.Exception.BizExceptionEnum;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;

import java.util.Date;

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
	@RequestMapping(value = "/queryAll",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<StudentModel> queryAll(@RequestParam(value = "page" ,defaultValue = "1") Integer page, Integer pageSize, StudentModel student) {
		//查询全部
		PageInfo<StudentModel>  pageInfo = studentService.queryAll(page,pageSize,student);
		return 	pageInfo;
	}
	/**
	 * @Description 新增学生信息
	 * @Param 
	 * @return 
	 **/
	@RequestMapping("/insertStudent")
	@ResponseBody
	public Object insertStudent(StudentModel studentModel){
		studentModel.setStatus(Status.ENABLE);
		String stuNo = getStudentNo();
		studentModel.setStudentNo(stuNo);
		boolean flag = studentService.insert(studentModel);
		if (flag) {
			return BizExceptionEnum.SUCCESS_TIP;
		} else {
			return "";
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
	public String updateStudent(StudentModel studentModel){
		if (ToolUtil.isOneEmpty(studentModel,studentModel.getId())) {

		}
		boolean flag = studentService.updateById(studentModel);
		if (flag) {
			return "";
		} else {
			return "";
		}
	}
	/**
	 * @Description 删除一条学生信息
	 * @Param
	 * @return
	 **/
	@RequestMapping("/deleteStudent")
	@ResponseBody
	public String deleteStudent(StudentModel studentModel){
		if (ToolUtil.isOneEmpty(studentModel,studentModel.getId())) {

		}
		studentModel.setStatus(Status.DISABLED);
		studentService.updateById(studentModel);
		return "";
	}

	/**
	 * @Description 生成学号
	 * @Param 
	 * @return 
	 **/
	public String getStudentNo(){
		StringBuffer stuNo = null;
		stuNo.append(DateUtil.formatDate(new Date(), "yyyy"));
		return String.valueOf(stuNo);
	}
}
