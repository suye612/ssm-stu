package com.ytj.ssm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.PyramidModelDao;
import com.ytj.ssm.model.Nodes;
import com.ytj.ssm.model.PyramidModel;
import com.ytj.ssm.service.IPyramidService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/9 20:36
 * @Description:
 */
@Service
public class PyramidModelSeriveImpl extends ServiceImpl<PyramidModelDao, PyramidModel> implements IPyramidService {
    @Override
    public List<Nodes> selectTree() {
        return baseMapper.selectTree();
    }

    @Override
    public Nodes selectNodesById(Integer pid) {
        return baseMapper.selectNodesById( pid);
    }

    @Override
    public void updateCidsById(Integer id) {
        baseMapper.updateCidsById(id);
    }
}
