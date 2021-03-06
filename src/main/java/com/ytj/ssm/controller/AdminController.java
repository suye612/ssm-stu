package com.ytj.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;

@Controller
public class AdminController {
	@Resource
	private IAdminService adminService;
	
	@RequestMapping("/login")
	//登录
	public String login(AdminModel admin, HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		System.out.println("登录界面");
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("username", admin.getUsername())
												  .and().eq("idcard", admin.getIdcard());
		AdminModel adminModel = adminService.selectOne(eq);
		if(ToolUtil.isNotEmpty(adminModel)){
			HttpSession session = request.getSession();
			session.setAttribute("admin",adminModel);
			System.out.println(11111);
			return "queryAll";
		}else{
		//登录失败
			 response.sendRedirect("index.jsp");
		}
		return null;
		
	}
	/**
	 *注册
	 * @throws IOException 
	 **/
	@RequestMapping("/reg")
	public String reg(AdminModel admin,HttpServletResponse response) throws IOException{
		admin.setStatus(Status.ENABLE);
		System.out.println(admin);
		boolean flag = adminService.insert(admin);
		if(flag){
		//	return "index";
			 response.sendRedirect("index.jsp");
					
		}else{
			return "reg";
		}
		return null;
	}
	/**
	 * 跳转到注册页面
	 **/
	@RequestMapping("/register")
	public String reg() {
		return "reg";
	}
	/**
	 * @return
	 * @Description 验证手机号是否已存在
	 * @Param
	 **/
	@RequestMapping("/admin/checkTel")
	@ResponseBody
	public Object checkTel(String tel) {
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("tel", tel);
		return adminService.selectList(eq);
	}
	/**
	 * @return
	 * @Description 验证姓名是否已存在
	 * @Param
	 **/
	@RequestMapping("/admin/checkName")
	@ResponseBody
	public Object checkName(String name) {
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("username", name);
		List<AdminModel> list = adminService.selectList(eq);
		return list;
	}
	/**
	 * @return
	 * @Description 验证身份证是否已存在
	 * @Param
	 **/
	@RequestMapping("/admin/checkIdcard")
	@ResponseBody
	public Object checkIdcard(String idcard) {
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("idcard", idcard);
		return adminService.selectList(eq);
	}
}
