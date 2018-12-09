package com.ytj.ssm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/9 20:31
 * @Description:
 */
@TableName("tb_pyramidModel")
@Data
public class PyramidModel extends Model<AdminModel> {
    private Integer id;
    private Integer pid;
    private String cids;
    private String name;
    private PyramidModel parentPyramid;
    List<PyramidModel> childrenPyramids;
    private Integer status;
    private Double membership;
    private Double commission;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
