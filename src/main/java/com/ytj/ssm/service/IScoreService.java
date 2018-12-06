package com.ytj.ssm.service;

import com.baomidou.mybatisplus.service.IService;
import com.ytj.ssm.model.ScoreModel;
import com.ytj.ssm.model.StudentAndScore;

/**
 * @Author: amin
 * @Date: 2018/12/4 19:49
 * @Description:
 */
public interface IScoreService extends IService<ScoreModel> {
    StudentAndScore selectStudentAndScore(Integer id);
}
