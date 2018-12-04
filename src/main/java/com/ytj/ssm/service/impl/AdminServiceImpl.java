package com.ytj.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<BaseMapper<AdminModel>, AdminModel> implements IAdminService{
	public void login(){
		//baseMapper.delete(queryWrapper);
	}
}
