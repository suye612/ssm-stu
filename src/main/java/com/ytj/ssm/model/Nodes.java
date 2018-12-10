package com.ytj.ssm.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/10 11:05
 * @Description:
 */
@Data
public class Nodes {
    private Integer id;
    private String name;
    private String cids;
    private List<Nodes> children;
    private Boolean spread;
}
