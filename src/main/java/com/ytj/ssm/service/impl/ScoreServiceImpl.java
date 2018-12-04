package com.ytj.ssm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.ScoreDao;
import com.ytj.ssm.model.ScoreModel;
import com.ytj.ssm.service.IScoreService;
import org.springframework.stereotype.Service;

/**
 * @Author: amin
 * @Date: 2018/12/4 19:50
 * @Description:
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreModel> implements IScoreService {
}
