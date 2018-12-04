package com.ytj.ssm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.AdminDao;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminModel> implements IAdminService{
	public void login(){
		//baseMapper.delete(queryWrapper);
	}
}
