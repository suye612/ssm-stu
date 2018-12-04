package com.ytj.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ytj.ssm.model.PageInfo;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;
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
	public PageInfo<StudentModel> queryAll(@RequestParam(value = "page" ,defaultValue = "1") Integer page, Integer pageSize, StudentModel student) {
		//查询全部
		return 	studentService.queryAll(page,pageSize,student);
	}
	@RequestMapping("/insertStudent")
	@ResponseBody
	public String insertStudent(StudentModel studentModel){
		studentModel.setStatus(Status.ENABLE);
		String stuNo = "";
		studentModel.setStudentNo(stuNo);
		boolean insert = studentService.insert(studentModel);
		return "";
	}
}
