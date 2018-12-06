package com.ytj.ssm.model;

import lombok.Data;

/**
 * @Author: amin
 * @Date: 2018/12/6 16:14
 * @Description: 学生信息和分数的 dto
 */
@Data
public class StudentAndScore {
    private String studentNo;
    private String name;
    private String sex;
    private Integer age;
    private Integer status;
    private String profession;
    private  Double chinese;
    private  Double math;
    private  Double english;
    private  Double art;
    private  Double music;
    private  Double history;
}
