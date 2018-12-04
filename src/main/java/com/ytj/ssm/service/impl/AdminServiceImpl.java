package com.ytj.ssm.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.AdminDao;
import com.ytj.ssm.model.AdminModel;
import com.ytj.ssm.service.IAdminService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminModel> implements IAdminService{
	public void login(){
		//baseMapper.delete(queryWrapper);
	}

	@Override
	public boolean insert(AdminModel entity) {
		return false;
	}

	@Override
	public boolean insertAllColumn(AdminModel entity) {
		return false;
	}

	@Override
	public boolean insertBatch(List<AdminModel> entityList) {
		return false;
	}

	@Override
	public boolean insertBatch(List<AdminModel> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean insertOrUpdateBatch(List<AdminModel> entityList) {
		return false;
	}

	@Override
	public boolean insertOrUpdateBatch(List<AdminModel> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean insertOrUpdateAllColumnBatch(List<AdminModel> entityList) {
		return false;
	}

	@Override
	public boolean insertOrUpdateAllColumnBatch(List<AdminModel> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean deleteById(Serializable id) {
		return false;
	}

	@Override
	public boolean deleteByMap(Map<String, Object> columnMap) {
		return false;
	}

	@Override
	public boolean delete(Wrapper<AdminModel> wrapper) {
		return false;
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		return false;
	}

	@Override
	public boolean updateById(AdminModel entity) {
		return false;
	}

	@Override
	public boolean updateAllColumnById(AdminModel entity) {
		return false;
	}

	@Override
	public boolean update(AdminModel entity, Wrapper<AdminModel> wrapper) {
		return false;
	}

	@Override
	public boolean updateForSet(String setStr, Wrapper<AdminModel> wrapper) {
		return false;
	}

	@Override
	public boolean updateBatchById(List<AdminModel> entityList) {
		return false;
	}

	@Override
	public boolean updateBatchById(List<AdminModel> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean updateAllColumnBatchById(List<AdminModel> entityList) {
		return false;
	}

	@Override
	public boolean updateAllColumnBatchById(List<AdminModel> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean insertOrUpdate(AdminModel entity) {
		return false;
	}

	@Override
	public boolean insertOrUpdateAllColumn(AdminModel entity) {
		return false;
	}

	@Override
	public AdminModel selectById(Serializable id) {
		return null;
	}

	@Override
	public List<AdminModel> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<AdminModel> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public AdminModel selectOne(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public Map<String, Object> selectMap(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public Object selectObj(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public int selectCount(Wrapper<AdminModel> wrapper) {
		return 0;
	}

	@Override
	public List<AdminModel> selectList(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public Page<AdminModel> selectPage(Page<AdminModel> page) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public Page<Map<String, Object>> selectMapsPage(Page page, Wrapper<AdminModel> wrapper) {
		return null;
	}

	@Override
	public Page<AdminModel> selectPage(Page<AdminModel> page, Wrapper<AdminModel> wrapper) {
		return null;
	}
}
