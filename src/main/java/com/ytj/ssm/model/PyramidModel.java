package com.ytj.ssm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String cids;
    private String name;
    @TableField(exist = false)
    private PyramidModel parentPyramid;
    @TableField(exist = false)
    List<PyramidModel> childrenPyramids;
    private Integer status;
    private Double membership;
    private Double commission;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
