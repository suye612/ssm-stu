package com.ytj.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ytj.ssm.util.ToolUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IStudentService;

@Controller
public class StudentController {

	@Resource
	private IStudentService studentService;
	
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
	public Object queryAll(@RequestParam(value = "page" ,defaultValue = "1") Integer page, Integer pageSize, StudentModel student) {
		//查询全部
        if (ToolUtil.isOneEmpty(page, pageSize)) {

        }
		return 	studentService.queryAll(page,pageSize,student);
	}
}
