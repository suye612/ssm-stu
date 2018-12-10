package com.ytj.ssm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ytj.ssm.model.Nodes;
import com.ytj.ssm.model.PyramidModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/9 20:34
 * @Description:
 */
public interface PyramidModelDao extends BaseMapper<PyramidModel> {
    List<Nodes> selectTree();

    Nodes selectNodesById(@Param("pid") Integer pid);

    void updateCidsById(@Param("id") Integer id);
}
