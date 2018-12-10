package com.ytj.ssm.service;

import com.baomidou.mybatisplus.service.IService;
import com.ytj.ssm.model.Nodes;
import com.ytj.ssm.model.PyramidModel;

import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/9 20:35
 * @Description:
 */
public interface IPyramidService extends IService<PyramidModel> {
    List<Nodes> selectTree();

    Nodes selectNodesById(Integer pid);

    void updateCidsById(Integer id);
}
