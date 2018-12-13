package com.ytj.ssm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;
import com.ytj.ssm.util.Exception.AppException;
import com.ytj.ssm.util.Exception.BizExceptionEnum;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author: amin
 * @Date: 2018/12/4 19:46
 * @Description: 管理员登录控制器
 */
@Controller
public class AdminController {
	@Resource
	private IAdminService adminService;
	
	
	@RequestMapping("/login")
	//登录
	public String login(AdminModel admin, HttpServletRequest request) throws IOException {
		if (ToolUtil.isOneEmpty(admin, admin.getUsername(), admin.getIdcard())) {
			throw new AppException(BizExceptionEnum.REGISTER_ERROR);
		}
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("username", admin.getUsername())
												  .and().eq("idcard", admin.getIdcard());
		AdminModel adminModel = adminService.selectOne(eq);
		if(ToolUtil.isNotEmpty(adminModel)){
			HttpSession session = request.getSession();
			session.setAttribute("admin",adminModel);
			return "main";
		}else{
		//登录失败
			return "index";
		}
	}
	/**
	 *注册
	 * @throws IOException 
	 **/
	@RequestMapping("/reg")
	public String reg(AdminModel admin ) throws IOException{
		admin.setStatus(Status.ENABLE);
		boolean flag = adminService.insert(admin);
		if(flag){
			return "index";
		}else{
			throw new AppException(BizExceptionEnum.REGISTER_ERROR);
		}
	}
	/**
	 * 跳转到注册页面
	 **/
	@RequestMapping("/register")
	public String reg() {
		return "reg";
	}
	/**
	 * 跳转到登录页面
	 **/
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/o")
	public String index2() {
		return "NewFile";
	}
	/**
	 * @return
	 * @Description 验证手机号是否已存在
	 * @Param
	 **/
	@RequestMapping("/admin/checkTel")
	@ResponseBody
	public Object checkTel(String tel) {
		System.out.println(1111+"tel");
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
		System.out.println(1111+"name");
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
		System.out.println(1111+"idcard");
		Wrapper<AdminModel> eq = new EntityWrapper<AdminModel>().eq("idcard", idcard);
		return adminService.selectList(eq);
	}
}
