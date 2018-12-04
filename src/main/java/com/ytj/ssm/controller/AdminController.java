package com.ytj.ssm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping("/login")
	//登录
	public String login(AdminModel admin, HttpServletRequest request, HttpServletResponse response) throws IOException {
		QueryWrapper<AdminModel> wrapper = new EmptyWrapper<AdminModel>();
		wrapper.and(i ->i.eq("username", admin.getUsername()).eq("idcard", admin.getIdcard()));
		List<AdminModel> list = adminService.list(wrapper);
		//登录成功
		if(list!=null && list.size()>0){
			HttpSession session = request.getSession();
			session.setAttribute("admin",list.get(0));
			return "queryAll";
		}else{
		//登录失败
			return "login";
		}
		
	}
	//立即注册
	@RequestMapping("/reg")
	public String reg(AdminModel admin){
		System.out.println(admin);
		boolean save = adminService.save(admin);
		if(save){
			return "login";
		}else{
			return "reg";
		}

	}
	//注册
	@RequestMapping("/register")
	public String reg() {
			return "reg";
	}

}
